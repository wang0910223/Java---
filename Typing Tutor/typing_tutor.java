import javax.swing.JOptionPane;
import java.awt.FlowLayout; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class typing_tutor
{
    public static void main(String[] args){
        myframe flowLayoutFrame = new myframe(); 
        flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flowLayoutFrame.setSize(1200, 800); 
        flowLayoutFrame.setVisible(true); 
    } 

}

class myframe extends JFrame{
    private JTextArea textArea; 
    private JLabel label;

    public myframe(){
        super("typing tutor");
        setLayout(null);

        // 新增提示文字的label
        label=new JLabel("please typing");
        label.setBounds(200,0,200, 40);
        add(label);

        // 新增textArea
        textArea = new JTextArea();
        textArea.setBounds(200,50,800,300); 
        add(textArea);
        
        // 新增所有按鍵、利用setBounds()設定座標位置、利用add()加入frame
        JButton[] buttons0_9,buttonsA_Z,buttonsOther,buttons4,buttons5;
        buttons0_9 = new JButton[10];
        buttonsA_Z=new JButton[26];
        for(int i=0;i<=9;i++){
            int n=(i+1)%10;
            String t=Integer.toString(n);
            buttons0_9[i]=new JButton(t);
            buttons0_9[i].setBounds(300+i*55,380,50,50); 
            add(buttons0_9[i]);
        }
        JButton minus=new JButton("-"), plus=new JButton("+"), back=new JButton("Backspace"), tab=new JButton("Tab");
        minus.setBounds(850, 380, 50, 50); plus.setBounds(905, 380, 50, 50); back.setBounds(960, 380, 100, 50); tab.setBounds(220, 435, 100, 50);
        add(minus); add(plus); add(back); add(tab);

        JButton Q=new JButton("Q"),W=new JButton("W"),E=new JButton("E"),R=new JButton("R"),T=new JButton("T"),Y=new JButton("Y"),
                U=new JButton("U"),I=new JButton("I"),O=new JButton("O"),P=new JButton("P"),l_m=new JButton("["),r_m=new JButton("]"),slash=new JButton("\\");
        Q.setBounds(325, 435, 50, 50); W.setBounds(380, 435, 50, 50); E.setBounds(435, 435, 50, 50); R.setBounds(490, 435, 50, 50); T.setBounds(545, 435, 50, 50); 
        Y.setBounds(600, 435, 50, 50); U.setBounds(655, 435, 50, 50); I.setBounds(710, 435, 50, 50); O.setBounds(765, 435, 50, 50); P.setBounds(820, 435, 50, 50); 
        l_m.setBounds(875, 435, 50, 50); r_m.setBounds(930, 435, 50, 50); slash.setBounds(985, 435, 50, 50); 
        add(Q);add(W);add(E);add(R);add(T);add(Y);add(U);add(I);add(O);add(P);add(l_m);add(r_m);add(slash);

        JButton caps=new JButton("Caps"),A=new JButton("A"),S=new JButton("S"),D=new JButton("D"),F=new JButton("F"),G=new JButton("G"),H=new JButton("H"),
                J=new JButton("J"),K=new JButton("K"),L=new JButton("L"),semi=new JButton(";"),quot=new JButton("\""),enter=new JButton("Enter");
        A.setBounds(325, 490, 50, 50); S.setBounds(380, 490, 50, 50); D.setBounds(435, 490, 50, 50); F.setBounds(490, 490, 50, 50); G.setBounds(545, 490, 50, 50); 
        H.setBounds(600, 490, 50, 50); J.setBounds(655, 490, 50, 50); K.setBounds(710, 490, 50, 50); L.setBounds(765, 490, 50, 50); semi.setBounds(820, 490, 50, 50); 
        quot.setBounds(875, 490, 50, 50); enter.setBounds(930, 490, 100, 50); caps.setBounds(220, 490, 100, 50);
        add(A);add(S);add(D);add(F);add(G);add(H);add(J);add(K);add(L);add(semi);add(quot);add(enter);add(caps);

        JButton sh=new JButton("Shift"),Z=new JButton("Z"),X=new JButton("X"),C=new JButton("C"),V=new JButton("V"),B=new JButton("B"),N=new JButton("N"),M=new JButton("M"),
                comma=new JButton(","),dot=new JButton("."),ques=new JButton("?"),up=new JButton("^"),down=new JButton("v"),left=new JButton("<"),right=new JButton(">"),space=new JButton("");
        Z.setBounds(325, 545, 50, 50); X.setBounds(380, 545, 50, 50); C.setBounds(435, 545, 50, 50); V.setBounds(490, 545, 50, 50); B.setBounds(545, 545, 50, 50); 
        N.setBounds(600, 545, 50, 50); M.setBounds(655, 545, 50, 50); comma.setBounds(710, 545, 50, 50); dot.setBounds(765, 545, 50, 50); ques.setBounds(820, 545, 50, 50);
        up.setBounds(930, 545, 50, 50);sh.setBounds(220, 545, 100, 50);down.setBounds(930, 600, 50, 50);right.setBounds(985, 600, 50, 50);left.setBounds(875, 600, 50, 50);space.setBounds(435, 600, 300, 50);
        add(Z);add(X);add(C);add(V);add(B);add(N);add(M);add(comma);add(dot);add(ques);add(up);add(sh);add(down);add(right);add(left);add(space);
        
        // handle keyboard event
        textArea.addKeyListener(
            new KeyAdapter() {
                Color reset=A.getBackground(); 
                //每個按鍵press時 將顏色設為綠色
                public void keyPressed(KeyEvent event){
                    
                    KeyEvent.getKeyText(event.getKeyCode());

                    if(event.getKeyChar()=='A'||event.getKeyChar()=='a'){
                        A.setBackground(Color.GREEN);
                        //System.out.printf("Key released: %s",event.getKeyChar());
                    }
                    else if(event.getKeyChar()=='B'||event.getKeyChar()=='b'){
                        B.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='C'||event.getKeyChar()=='c'){
                        C.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='D'||event.getKeyChar()=='d'){
                        D.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='E'||event.getKeyChar()=='e'){
                        E.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='F'||event.getKeyChar()=='f'){
                        F.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='G'||event.getKeyChar()=='g'){
                        G.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='H'||event.getKeyChar()=='h'){
                        H.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='I'||event.getKeyChar()=='i'){
                        I.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='J'||event.getKeyChar()=='j'){
                        J.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='K'||event.getKeyChar()=='k'){
                        K.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='L'||event.getKeyChar()=='l'){
                        L.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='M'||event.getKeyChar()=='m'){
                        M.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='N'||event.getKeyChar()=='n'){
                        N.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='O'||event.getKeyChar()=='o'){
                        O.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='P'||event.getKeyChar()=='p'){
                        P.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='Q'||event.getKeyChar()=='q'){
                        Q.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='R'||event.getKeyChar()=='r'){
                        R.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='S'||event.getKeyChar()=='s'){
                        S.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='T'||event.getKeyChar()=='t'){
                        T.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='U'||event.getKeyChar()=='u'){
                        U.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='V'||event.getKeyChar()=='v'){
                        V.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='W'||event.getKeyChar()=='w'){
                        W.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='X'||event.getKeyChar()=='x'){
                        X.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='Y'||event.getKeyChar()=='y'){
                        Y.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='Z'||event.getKeyChar()=='z'){
                        Z.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()==','||event.getKeyChar()=='<'){
                        comma.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='.'||event.getKeyChar()=='>'){
                        dot.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='/'||event.getKeyChar()=='?'){
                        ques.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='['||event.getKeyChar()=='{'){
                        l_m.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()==']'||event.getKeyChar()=='}'){
                        r_m.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='\\'||event.getKeyChar()=='|'){
                        slash.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()==' '||event.getKeyChar()==' '){
                        space.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='-'||event.getKeyChar()=='_'){
                        minus.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='='||event.getKeyChar()=='+'){
                        plus.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()==':'||event.getKeyChar()==';'){
                        semi.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='\"'||event.getKeyChar()=='\''){
                        quot.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='\n'||event.getKeyChar()=='\n'){
                        enter.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='\t'||event.getKeyChar()=='\t'){
                        tab.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='1'){
                        buttons0_9[0].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='2'){
                        buttons0_9[1].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='3'){
                        buttons0_9[2].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='4'){
                        buttons0_9[3].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='5'){
                        buttons0_9[4].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='6'){
                        buttons0_9[5].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='7'){
                        buttons0_9[6].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='8'){
                        buttons0_9[7].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='9'){
                        buttons0_9[8].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyChar()=='0'){
                        buttons0_9[9].setBackground(Color.GREEN);
                    }
                    else if(event.getKeyCode()==0x26){
                        up.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyCode()==0x25){
                        left.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyCode()==0x27){
                        right.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyCode()==0x28){
                        down.setBackground(Color.GREEN);
                    }

                    else if(event.getKeyCode()==0x14){
                        caps.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyCode()==0x10){
                        sh.setBackground(Color.GREEN);
                    }
                    else if(event.getKeyCode()==0x08){
                        back.setBackground(Color.GREEN);
                    }
                }
                //每個按鍵release時 將顏色設回初始顏色
                public void keyReleased(KeyEvent event){
                    KeyEvent.getKeyText(event.getKeyCode());
                    if(event.getKeyChar()=='A'||event.getKeyChar()=='a'){
                        A.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='B'||event.getKeyChar()=='b'){
                        B.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='C'||event.getKeyChar()=='c'){
                        C.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='D'||event.getKeyChar()=='d'){
                        D.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='E'||event.getKeyChar()=='e'){
                        E.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='F'||event.getKeyChar()=='f'){
                        F.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='G'||event.getKeyChar()=='g'){
                        G.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='H'||event.getKeyChar()=='h'){
                        H.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='I'||event.getKeyChar()=='i'){
                        I.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='J'||event.getKeyChar()=='j'){
                        J.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='K'||event.getKeyChar()=='k'){
                        K.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='L'||event.getKeyChar()=='l'){
                        L.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='M'||event.getKeyChar()=='m'){
                        M.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='N'||event.getKeyChar()=='n'){
                        N.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='O'||event.getKeyChar()=='o'){
                        O.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='P'||event.getKeyChar()=='p'){
                        P.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='Q'||event.getKeyChar()=='q'){
                        Q.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='R'||event.getKeyChar()=='r'){
                        R.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='S'||event.getKeyChar()=='s'){
                        S.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='T'||event.getKeyChar()=='t'){
                        T.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='U'||event.getKeyChar()=='u'){
                        U.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='V'||event.getKeyChar()=='v'){
                        V.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='W'||event.getKeyChar()=='w'){
                        W.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='X'||event.getKeyChar()=='x'){
                        X.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='Y'||event.getKeyChar()=='y'){
                        Y.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='Z'||event.getKeyChar()=='z'){
                        Z.setBackground(reset);
                    }
                    else if(event.getKeyChar()==','||event.getKeyChar()=='<'){
                        comma.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='.'||event.getKeyChar()=='>'){
                        dot.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='/'||event.getKeyChar()=='?'){
                        ques.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='['||event.getKeyChar()=='{'){
                        l_m.setBackground(reset);
                    }
                    else if(event.getKeyChar()==']'||event.getKeyChar()=='}'){
                        r_m.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='\\'||event.getKeyChar()=='|'){
                        slash.setBackground(reset);
                    }
                    else if(event.getKeyChar()==' '||event.getKeyChar()==' '){
                        space.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='-'||event.getKeyChar()=='_'){
                        minus.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='='||event.getKeyChar()=='+'){
                        plus.setBackground(reset);
                    }
                    else if(event.getKeyChar()==':'||event.getKeyChar()==';'){
                        semi.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='\"'||event.getKeyChar()=='\''){
                        quot.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='\n'||event.getKeyChar()=='\n'){
                        enter.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='\t'||event.getKeyChar()=='\t'){
                        tab.setBackground(reset);
                    }
                    else if(event.getKeyChar()=='1'){
                        buttons0_9[0].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='2'){
                        buttons0_9[1].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='3'){
                        buttons0_9[2].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='4'){
                        buttons0_9[3].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='5'){
                        buttons0_9[4].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='6'){
                        buttons0_9[5].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='7'){
                        buttons0_9[6].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='8'){
                        buttons0_9[7].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='9'){
                        buttons0_9[8].setBackground(reset);
                    }
                    else if(event.getKeyChar()=='0'){
                        buttons0_9[9].setBackground(reset);
                    }
                    else if(event.getKeyCode()==0x26){
                        up.setBackground(reset);
                    }
                    else if(event.getKeyCode()==0x25){
                        left.setBackground(reset);
                    }
                    else if(event.getKeyCode()==0x27){
                        right.setBackground(reset);
                    }
                    else if(event.getKeyCode()==0x28){
                        down.setBackground(reset);
                    }

                    else if(event.getKeyCode()==0x14){
                        caps.setBackground(reset);
                    }
                    else if(event.getKeyCode()==0x10){
                        sh.setBackground(reset);
                    }
                    else if(event.getKeyCode()==0x08){
                        back.setBackground(reset);
                    }
    
                }
            }
        );
        
    }
}

