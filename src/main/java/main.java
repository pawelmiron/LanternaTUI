import java.nio.charset.Charset;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.Component.Alignment;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.component.Panel.Orientation;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.layout.VerticalLayout;
import com.googlecode.lanterna.terminal.TerminalSize;

public class main {

    public static void test3() {
        //Tworzenie obiektow//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final GUIScreen guiScreen = TerminalFacade.createGUIScreen(); //Tworze główny ekran konsoli w ktorym wyswietlane sa wszystkie okna
        Button GoBackButton = new Button("Powrót", new Action() {
            public void doAction() {
                guiScreen.getActiveWindow().close();
            }
        });
        GoBackButton.setAlignment(Alignment.TOP_RIGHT);
        //Dodaj Utwor Screen///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        final Window DUWindow = new Window("GLOWNE OKNO");
        DUWindow.setWindowSizeOverride(new TerminalSize(100,50));
        DUWindow.setSoloWindow(true);
        Panel DUpanelHolder = new Panel("", Orientation.HORISONTAL);
        DUpanelHolder.setLayoutManager(new VerticalLayout());
        Panel DUmenuGlowne = new Panel("Menu Glowne", Orientation.HORISONTAL);

        Label DULabel = new Label("Dodadwanie piosenki");
        DULabel.setAlignment(Alignment.TOP_LEFT);

        Panel DUcontent = new Panel("Content", Orientation.HORISONTAL);
        DUcontent.setLayoutManager(new VerticalLayout());

        Table DUTable = new Table(2);
        DUTable.setColumnPaddingSize(7);

        Component[] DUrow1 = new Component[2];
        DUrow1[0] = new Label("   Album");
        DUrow1[1] = new TextBox("",69);
        DUTable.addRow(DUrow1);

        DUTable.addRow(new EmptySpace());

        Component[] DUrow2 = new Component[2];
        DUrow2[0] = new Label("   Title");
        DUrow2[1] = new TextBox("",69);
        DUrow2[1].setAlignment(Alignment.FILL);
        DUTable.addRow(DUrow2);

        DUTable.addRow(new EmptySpace());

        Button dodaj3 = new Button("Dodaj");
        dodaj3.setAlignment(Alignment.RIGHT_CENTER);

        //Dodawanie obiektow do obiektow
        DUcontent.addComponent(DUTable);
        DUcontent.addComponent(dodaj3, LinearLayout.MAXIMIZES_HORIZONTALLY);
        DUmenuGlowne.addComponent(DULabel);
        DUmenuGlowne.addComponent(new EmptySpace(52,0));
        DUmenuGlowne.addComponent(GoBackButton);
        DUpanelHolder.addComponent(DUmenuGlowne);
        DUpanelHolder.addComponent(DUcontent);
        DUWindow.addComponent(DUpanelHolder);

        //Pokaz Utwory Screen//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final Window PUWindow = new Window("POKAZ UTWORY");
        PUWindow.setWindowSizeOverride(new TerminalSize(100,500));
        PUWindow.setSoloWindow(true);
        Panel PUPanelHolder = new Panel("", Orientation.HORISONTAL);
        PUPanelHolder.setLayoutManager(new VerticalLayout());
        Panel PUmenuGlowne = new Panel("Menu", Orientation.HORISONTAL);
        Panel PUContent = new Panel("Content", Orientation.HORISONTAL);
        Label PUlabel = new Label("Lista utworow");
        Table PUtable = new Table(2);
        PUtable.setColumnPaddingSize(5);
        Component [] PUrow;
        for (int i=0; i<10; i++)
        {
            PUrow = new Component[2];
            PUrow[0] = new Label("Title " + i);
            PUrow[1] = new Label("Album" + i);
            PUtable.addRow(PUrow);
        }

        PUContent.addComponent(PUtable);
        PUmenuGlowne.addComponent(PUlabel);
        PUmenuGlowne.addComponent(new EmptySpace(58 ,0));
        PUmenuGlowne.addComponent(GoBackButton);
        PUPanelHolder.addComponent(PUmenuGlowne);
        PUPanelHolder.addComponent(PUContent);
        PUWindow.addComponent(PUPanelHolder);



        //Dodaj Album Screen //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final Window DAWindow = new Window("DODAJ ALBUM");                                   //Tworze pierwsze okienko wyswietlane zaraz po uruchomieniu ekranu
        DAWindow.setWindowSizeOverride(new TerminalSize(100,50));                            //Ustawiam wielkosc okna 1 na maksymalny rozmiar
        DAWindow.setSoloWindow(true);                                                        //Dzieki wartosci true gdy pokazujemy te okno inne znikaja

        Panel DApanelHolder = new Panel("", Orientation.HORISONTAL);
        DApanelHolder.setLayoutManager(new VerticalLayout());
        Panel DAmenuGlowne = new Panel("Menu Glowne", Orientation.HORISONTAL);

        Label DALabel = new Label("Dodadwanie piosenki");
        DALabel.setAlignment(Alignment.TOP_LEFT);

        Panel DAContent = new Panel("Content", Orientation.HORISONTAL);
        DAContent.setLayoutManager(new VerticalLayout());

        Table DAtable = new Table(2);
        DAtable.setColumnPaddingSize(7);

        Component[] DArow1 = new Component[2];
        Component[] DArow2 = new Component[2];
        Component[] DArow3 = new Component[2];
        Component[] DArow4 = new Component[2];

        DArow1[0] = new Label("   Artist");
        DArow1[1] = new TextBox("",69);
        DArow2[0] = new Label("   Title");
        DArow2[1] = new TextBox("",69);
        DArow2[1].setAlignment(Alignment.FILL);
        DArow3[0] = new Label("   Genre");
        DArow3[1] = new TextBox("",69);



        DArow4[0] = new Label("   URL");
        DArow4[1] = new TextBox("",69);

        DAtable.addRow(DArow1);
        DAtable.addRow(new EmptySpace());
        DAtable.addRow(DArow2);
        DAtable.addRow(new EmptySpace());
        DAtable.addRow(DArow3);
        DAtable.addRow(new EmptySpace());
        DAtable.addRow(DArow4);
        DAtable.addRow(new EmptySpace());

        Button dodaj1 = new Button("Dodaj");
        dodaj1.setAlignment(Alignment.RIGHT_CENTER);

        DAContent.addComponent(DAtable);
        DAContent.addComponent(dodaj1, LinearLayout.MAXIMIZES_HORIZONTALLY);
        DAmenuGlowne.addComponent(DALabel);
        DAmenuGlowne.addComponent(new EmptySpace(52,0));
        DAmenuGlowne.addComponent(GoBackButton);
        DApanelHolder.addComponent(DAmenuGlowne);
        DApanelHolder.addComponent(DAContent);
        DAWindow.addComponent(DApanelHolder);

        //////////////////////////Pierwsze okno /////////////////////////////////////////////////////////////////////////////////////////////////
        final Window PAWindow = new Window("GLOWNE OKNO"); //Tworze pierwsze okienko wyswietlane zaraz po uruchomieniu ekranu
        PAWindow.setWindowSizeOverride(new TerminalSize(100,50)); //Ustawiam wielkosc okna 1 na maksymalny rozmiar
        PAWindow.setSoloWindow(true); //Dzieki wartosci true gdy pokazujemy te okno inne znikaja
        Panel panelHolder1 = new Panel("", Orientation.HORISONTAL);
        panelHolder1.setLayoutManager(new VerticalLayout());
        Panel menuGlowne1 = new Panel("Menu Glowne", Orientation.HORISONTAL);
        Button dodajAlbum = new Button("Dodaj Album", new Action() {
            public void doAction() {
                guiScreen.showWindow(DAWindow);
            }
        });
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        Button dodajUtwor = new Button("Dodaj Utwor", new Action() {
            public void doAction() {
                guiScreen.showWindow(DUWindow);
            }
        });

        Button ExitBTN = new Button("Exit", new Action() {
            public void doAction() {
                PAWindow.close();
            }
        });
        Button pokazUtwory = new Button("Pokaz Utwory", new Action() {
            public void doAction() {
                guiScreen.showWindow(PUWindow);
            }
        });
        Panel content1 = new Panel("Content", Orientation.HORISONTAL);
        Table table = new Table(4);
        table.setColumnPaddingSize(5);
        Component[] PArow;
        for (int i=0 ; i<10; i++)
        {
            PArow = new Component[4];
            PArow[0] = new Label("Artist " + i);
            PArow[1] = new Label("Title " + i);
            PArow[2] = new Label("Genre " + i);
            PArow[3] = new Label("Url " + i);
            table.addRow(PArow);

        }
        //Dodawanie obiektow do obiektow
        content1.addComponent(table);
        menuGlowne1.addComponent(dodajAlbum);
        menuGlowne1.addComponent(dodajUtwor);
        menuGlowne1.addComponent(pokazUtwory);
        menuGlowne1.addComponent(new EmptySpace(27,0));
        menuGlowne1.addComponent(ExitBTN);
        panelHolder1.addComponent(menuGlowne1);
        panelHolder1.addComponent(content1);
        PAWindow.addComponent(panelHolder1); //dodaje panelHolder do okna 1
        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(PAWindow);
        guiScreen.getScreen().stopScreen();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        test3();

    }


}