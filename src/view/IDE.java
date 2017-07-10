package view;

import java.awt.Event;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;
import simplejava.AcoesSemanticas;

//import simplejava.ASTBaseListener;
import simplejava.ErroSintaxeException;
import simplejava.ErroSintaxeListener;
import simplejava.simpleJavaLexer;
import simplejava.simpleJavaParser;
import tabela.Table;

public class IDE {
    private JFrame frame;
    private File file;
    private RSyntaxTextArea textArea;
    private RSyntaxTextArea console = new RSyntaxTextArea();
    DefaultListModel listModel = new DefaultListModel();
    private String path;
    private boolean flag = false;
    private JTabbedPane tabbedPane;
    private RTextScrollPane scrollPane;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable () {  
            public void run() {
                try {
                    String laf = UIManager.getSystemLookAndFeelClassName();
                    UIManager.setLookAndFeel(laf);
                    IDE window = new IDE();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public IDE() {
        textArea = new RSyntaxTextArea();
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/JavaSimplificado", "view.Sintaxe");
        textArea.setSyntaxEditingStyle("text/JavaSimplificado");
        textArea.setFocusable(true);
        init();
    }
    
    private void init (){
        frame = new JFrame();
        //frame.setBounds(100, 100, 667, 421);
        frame.setBounds(400, 100, 700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        
        JMenu menuFile = new JMenu("Arquivo");
        
        //key stroke funcao pra criar novo arquivo
        JMenuItem buttonNewFile = new JMenuItem("Novo arquivo Ctrl+N");    
        buttonNewFile.setMnemonic(KeyEvent.VK_N);
        KeyStroke keyStrokeToNewFile = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
		buttonNewFile.setAccelerator(keyStrokeToNewFile);
        
        //key stroke funcao pra abrir arquivo
        JMenuItem buttonOpenFile = new JMenuItem("Abrir arquivo Ctrl+O");
        buttonOpenFile.setMnemonic(KeyEvent.VK_O);
        KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		buttonOpenFile.setAccelerator(keyStrokeToOpen);
        
        //key stroke funcao pra salvar arquivo
        JMenuItem buttonSaveFile = new JMenuItem("Salvar arquivo Ctrl+S");
        buttonSaveFile.setMnemonic(KeyEvent.VK_S);
        KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		buttonSaveFile.setAccelerator(keyStrokeToSave);
                
        JMenuItem buttonSaveFileAs = new JMenuItem("Salvar arquivo como");
        JMenuItem buttonExit = new JMenuItem("Sair");
        
        menu.add(menuFile);
        menuFile.add(buttonNewFile);
        menuFile.add(buttonOpenFile);
        menuFile.add(buttonSaveFile);
        menuFile.add(buttonSaveFileAs);
        menuFile.add(buttonExit);
        
        JMenu menuRun = new JMenu("Executar");
        JMenuItem buttonCompileFile = new JMenuItem("Compilar Ctrl+E");
        KeyStroke keyStrokeToCompile = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
		buttonCompileFile.setAccelerator(keyStrokeToCompile);
        
        menu.add(menuRun);
        menuRun.add(buttonCompileFile);
        
        JMenu menuAbout = new JMenu("About");
        JMenuItem buttonAbout = new JMenuItem("O Projeto");
        buttonAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msgProjeto = "*Projeto Simple Java*\n"
                        + "*Alunos\n"
                        + "-Antonio Fabricio: IDE e Geração\n"
                        + "-Jonatas Blendo: Semantica Geração\n"
                        + "-Moises Batista: Gramatica e Geração\n";
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, msgProjeto);
                System.exit(0);
            }
        });
        
        menu.add(menuAbout);
        menuAbout.add(buttonAbout);
        
        
        KeyStroke keySave = KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK);
        Action performSave = new AbstractAction("Salvar") {
            public void actionPerformed(ActionEvent e) {
                if (path == null)
                    saveFileAs();
                else
                    saveFile();
            }
        };
        
        buttonSaveFile.getActionMap().put("performSave", performSave);
        buttonSaveFile.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keySave, "performSave");
        
        buttonCompileFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!flag)
                        run();
                    else{
                        int state = JOptionPane.showConfirmDialog(null, "Arquivo modificado. Deseja salvar?");
                        if (state == JOptionPane.YES_OPTION) {
                            if (path == null)
                                saveFileAs();
                            else
                                saveFile();
                        } else if (state == JOptionPane.CANCEL_OPTION) 
                            return;
                    }
                } catch (IOException e1) {
                    console.setText(e1.getMessage());
                }
            }
        });
        
        //JMenuItem buttonExecuteFile = new JMenuItem("Execute file");
        //menuRun.add(buttonExecuteFile);
        
        JList listaArq = new JList(listModel);
        JTabbedPane tabbedPaneAux = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        ScrollPane scroolPaneConsole = new ScrollPane();
        scroolPaneConsole.add(console);
        tabbedPaneAux.addTab("Console", null, scroolPaneConsole, null);
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                .addGap(7)
                .addComponent(listaArq, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addComponent(tabbedPaneAux, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                .addGap(7)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                .addGap(3)
                .addComponent(listaArq, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addGap(10)
                .addComponent(tabbedPaneAux, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
                .addGap(4))
        );
        frame.getContentPane().setLayout(groupLayout);
        
        buttonOpenFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(fc.FILES_ONLY);

                createTextArea();

                int aux = fc.showOpenDialog(textArea);
                if (aux == fc.CANCEL_OPTION)
                    return;
                else {
                    file = fc.getSelectedFile();
                    listModel.addElement(file.getName());
                    scrollPane = new RTextScrollPane(textArea);
                    tabbedPane.addTab(file.getName(), null, scrollPane, null);
                    openFile(file);
                }
            }
        });
        
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        buttonSaveFileAs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFileAs();
            }
        });
        
        buttonSaveFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textArea != null) {
                    if (path != null)
                        saveFileAs();
                    else
                        saveFile();
                } else
                    JOptionPane.showMessageDialog(null, "Não existe nenhum arquivo aberto!", 
                            "Save file", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        buttonNewFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                tabbedPane.removeAll();
                createTextArea();
                listModel.addElement("novo *");
                scrollPane = new RTextScrollPane(textArea);
                tabbedPane.addTab("novo *", null, scrollPane, null);
                flag = true;
            }
        });
//        Component c = new Component();
//        KeyEvent ke = new KeyEvent(source, id, when, modifiers, keyCode, keyChar)
//        console.addKeyListener();
        
        
        
    }
    
    private void openFile(File f) {
        try {
            FileReader fileReader = new FileReader(f);
            int cont = fileReader.read();
            String text = "";
            while(cont != -1) {
                text += (char) cont;
                cont = fileReader.read();
            }
            this.textArea.setText(text);
            path = f.getAbsolutePath();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void run() throws IOException {
        if(!textArea.getText().isEmpty()) {
            InputStream inputStream = new FileInputStream(file);
            ANTLRInputStream input = new ANTLRInputStream(inputStream);
            
            // Lexer
            simpleJavaLexer lexer = new simpleJavaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            //Sintático
            ErroSintaxeListener syntaxError = new ErroSintaxeListener();
            
            // Parser
            simpleJavaParser parser = new simpleJavaParser(tokens);
            parser.addErrorListener(syntaxError);
            
            //ParseTree tree = parser.prog();
            ParseTree tree = parser.programa();

            ParseTreeWalker walker = new ParseTreeWalker();
            //ASTBaseListener acoesSemanticas = new ASTBaseListener(parser, console);
            AcoesSemanticas acoesSemanticas = new AcoesSemanticas(new Table(), file.getName());
            walker.walk(acoesSemanticas, tree);
            
            //Estou passando minha tabela pro listenner
            
            
        
            System.out.println("oqtem: " + console.getText());
            
            console.setText("");
            
            if(!syntaxError.getErroSintaxe().isEmpty()) {
            	String erroNaSintaxe = "";
                for(ErroSintaxeException erro: syntaxError.getErroSintaxe()) {
                	erroNaSintaxe += erro.toString() + "\n";
//                    console.setText(erro.toString() + "\n");
                }                
                console.setText(erroNaSintaxe);
                
            } else {
                if(!acoesSemanticas.mensagemErro.isEmpty()) {
                	String erroNaSemantica = acoesSemanticas.msgCompilacao;
                    for(String erro: acoesSemanticas.mensagemErro) {
                    	erroNaSemantica += erro + "\n";
//                      console.setText(console.getText() + erro);
                    }
                    console.setText(erroNaSemantica);
                    
                } else {
                	System.out.println("oqtem: " + console.getText());
                        console.setText(acoesSemanticas.msgCompilacao);
                	//console.setText( (acoesSemanticas.saida.size() > 0 ? acoesSemanticas.saida + "\n" : ""));
//                	console.setText( acoesSemanticas.saida + "\n" + console.getText()+ "\n");// + tree.toStringTree(parser));
//                	 console.setText(console.getText() + tree.toStringTree(parser));
                }
            }
        }
    }
    
    private void createTextArea() {
//        textArea.setCodeFoldingEnabled(true);
//        textArea.setAntiAliasingEnabled(true);
//        RSyntaxTextArea.setTemplatesEnabled(true);
//        CodeTemplateManager ctm = RSyntaxTextArea.getCodeTemplateManager();
//        CodeTemplate ct = new StaticCodeTemplate("for", "para i de 0 ate ", " passo 1 faca {\n\t\n}\n");
//        ctm.addTemplate(ct);
//        CodeTemplate ct = new StaticCodeTemplate("if", "if ( ", " ) {\n\t\n}\n");
//        ctm.addTemplate(ct);
//        ct = new StaticCodeTemplate("senao", "senao {\n\t\n}\n", null);
//        ctm.addTemplate(ct);
//        ct = new StaticCodeTemplate("enquanto", "enquanto ( ", " ) {\n\t\n}\n");
//        ctm.addTemplate(ct);
//        ct = new StaticCodeTemplate("ler", "ler ( ", " ) ;");
//        ctm.addTemplate(ct);
//        ct = new StaticCodeTemplate("escrever", "escrever ( ", " ) ;");
//        ctm.addTemplate(ct);
        
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e) {
                super.keyTyped(e);
                if (!flag) {
                    flag = true;
                    tabbedPane.removeAll();
                    tabbedPane.addTab(file.getName()+" *", null, scrollPane, null);
                }
            }
        }); 
    }
    
    private void saveFileAs() {
        if(textArea != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int cont = fileChooser.showSaveDialog(null);
            if(cont != 1) {
                file = fileChooser.getSelectedFile();
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(textArea.getText());
                    fileWriter.close();
                    path = file.getAbsolutePath();
                    flag = false;
                    listModel.removeAllElements();
                    tabbedPane.removeAll();
                    listModel.addElement(file.getName());
                    tabbedPane.addTab(file.getName(), null, scrollPane, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void saveFile() {
        file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(textArea.getText());
            fileWriter.close();
            flag = false;
            listModel.removeAllElements();
            tabbedPane.removeAll();
            listModel.addElement(file.getName());
            tabbedPane.addTab(file.getName(), null, scrollPane, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
