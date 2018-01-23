package application;

import java.util.HashMap;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			HashMap<String, Match> listeMatch = new HashMap<>();
			BorderPane root = new BorderPane();
			// head//////////////////////////////////////////////////////////
			// Création de la barre de menus
			MenuBar menubar = new MenuBar();

			// Création du menu principal Fichiers
			Menu menufichier = new Menu("Fichiers");
			// sous-menus
			MenuItem Nouveau = new MenuItem("Nouveau");
			MenuItem Ouvrir = new MenuItem("Ouvrir");
			MenuItem Quitter = new MenuItem("Quitter");
			menufichier.getItems().addAll(Nouveau, Ouvrir, new SeparatorMenuItem(), Quitter);

			// Création du menu principal Match
			Menu menumatch = new Menu("Match");
			// sous-menus
			ToggleGroup matchs = new ToggleGroup();
			RadioMenuItem Poule = new RadioMenuItem("Poule");
			Poule.setSelected(true);
			RadioMenuItem Poule1 = new RadioMenuItem("Poule 1");
			RadioMenuItem Poule2 = new RadioMenuItem("Poule 2");
			RadioMenuItem Poule3 = new RadioMenuItem("Poule 3");
			RadioMenuItem Finale_8 = new RadioMenuItem("1/8 Finale");
			RadioMenuItem Finale_4 = new RadioMenuItem("1/4 Finale");
			RadioMenuItem Finale_2 = new RadioMenuItem("1/2 Finale");
			RadioMenuItem Finale = new RadioMenuItem("Finale");

			Poule.setToggleGroup(matchs);
			Poule1.setToggleGroup(matchs);
			Poule2.setToggleGroup(matchs);
			Poule3.setToggleGroup(matchs);
			Finale_8.setToggleGroup(matchs);
			Finale_4.setToggleGroup(matchs);
			Finale_2.setToggleGroup(matchs);
			Finale.setToggleGroup(matchs);

			menumatch.getItems().addAll(Poule, Poule1, Poule2, Poule3, Finale_8, Finale_4, Finale_2, Finale);

			// Création du menu principal Statistiques
			Menu menustatistiques = new Menu("Statistiques");

			// ajout des 3 menus dans la barre de menu
			menubar.getMenus().addAll(menufichier, menumatch, menustatistiques);

			// ajout de la barre de menu à la position TOP de root (borderPane)
			root.setTop(menubar);

			// centre//////////////////////////////////////////

			// création d'un rootcenter en type gridpane et ajoute de celui ci au centre du
			// root (borderPane)
			GridPane rootcenter = new GridPane();
			rootcenter.setAlignment(Pos.CENTER);
			rootcenter.setHgap(10);
			rootcenter.setVgap(10);
			rootcenter.setPadding(new Insets(25, 25, 25, 25));
			root.setCenter(rootcenter);

			Label titre = new Label("Match du mondial ");
			titre.setFont(new Font("Arial", 30));

			Label phase = new Label("Phase : ");
			phase.setFont(new Font("Arial", 20));

			Label contre = new Label("Contre : ");
			contre.setFont(new Font("Arial", 20));

			ChoiceBox<String> choixPhase = new ChoiceBox<String>();
			choixPhase.setItems(FXCollections.observableArrayList("Poule", "Poule 1", "Poule 2", "Poule 3",
					"1/8 Finale", "1/4 Finale", "1/2 Finale", "Finale"));
			choixPhase.getSelectionModel().select(0);
			choixPhase.setPrefWidth(120);

			TextField tfContre = new TextField();
			tfContre.setPromptText("Adversaire");
			Label joueurs = new Label("Les joueurs : ");
			joueurs.setFont(new Font("Arial", 20));

			String nomsdesjoueurs[] = { "Lloris", "Ruffier", "Landreau", "Debuchy", "Sagna", "Koscielny", "Mangala",
					"Sakho", "Varane", "Evra", "Digne", "Cabaye", "Pogba", "Matuidi", "Mavuba", "Sissoko",
					"Schneiderlin", "Valbuena", "Benzema", "Cabella", "Giroud", "Griezmann", "Rémy" };
			ObservableList<String> olnoms = FXCollections.observableArrayList(nomsdesjoueurs);
			ListView<String> listViewNoms = new ListView<String>(olnoms.sorted());
			listViewNoms.setEditable(true);

			Label equipe = new Label("L'équipe : ");
			equipe.setFont(new Font("Arial", 20));

			ObservableList<String> olequipe = FXCollections.observableArrayList();
			ListView<String> listViewEquipe = new ListView<String>(olequipe);
			listViewEquipe.setEditable(true);

			Button btnVdroite = new Button("  >  ");
			btnVdroite.setPrefWidth(40);
			Button btnVgauche = new Button("  < ");
			btnVgauche.setPrefWidth(40);

			rootcenter.add(titre, 3, 1, 6, 1);// 3.debut gauche - 1.debut haut - 4.nbr colones pris en longueur - 1nbr
												// lignes pris en largeur
			rootcenter.add(phase, 2, 3, 3, 1);
			rootcenter.add(choixPhase, 3, 3);
			rootcenter.add(contre, 7, 3);
			rootcenter.add(tfContre, 8, 3, 9, 1);
			rootcenter.add(joueurs, 2, 6);
			rootcenter.add(equipe, 7, 6);
			rootcenter.add(listViewNoms, 1, 7, 3, 8);
			rootcenter.add(listViewEquipe, 7, 7, 10, 8);
			rootcenter.add(btnVdroite, 6, 7);
			rootcenter.add(btnVgauche, 6, 9);

			// foot//////////////////////////////////////////
			HBox hbox = new HBox(30);
			hbox.setPadding(new Insets(20, 50, 20, 20));
			hbox.setAlignment(Pos.BOTTOM_RIGHT);
			Button btncxl = new Button("  Annuler  ");
			Button btnok = new Button("  Validez  ");
			hbox.getChildren().addAll(btncxl, btnok);

			root.setBottom(hbox);

			Scene scene = new Scene(root, 700, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			// gestion des évènements////////////////////

			btnVdroite.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub

				}

			});

			btnVdroite.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub

					String nom = listViewNoms.getSelectionModel().getSelectedItem();

					if (nom != null) {
						olequipe.add(nom);
						listViewEquipe.setItems(olequipe.sorted());
						olnoms.remove(nom);
						listViewNoms.setItems(olnoms.sorted());

					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Message d'erreur");
						alert.setHeaderText("Erreur");
						alert.setContentText("Champs vides!!!");

						alert.showAndWait();
					}

				}
			});

			btnVgauche.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String nom = listViewEquipe.getSelectionModel().getSelectedItem();

					if (nom != null) {
						olnoms.add(nom);
						listViewNoms.setItems(olnoms.sorted());
						olequipe.remove(nom);
						listViewEquipe.setItems(olequipe.sorted());

					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Message d'erreur");
						alert.setHeaderText("Erreur");
						alert.setContentText("Champs vides!!!");

						alert.showAndWait();
					}

				}

			});

			btncxl.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					olnoms.setAll(nomsdesjoueurs);
					listViewNoms.setItems(olnoms);
					olequipe.clear();
					listViewEquipe.setItems(olequipe);
				}

			});

			btnok.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					String messageError = "";
					if (choixPhase.getSelectionModel().getSelectedItem() == "Poule") {
						messageError += "Veuillez choisir une poule! \n";
					}
					if (tfContre.getText().isEmpty()) {
						messageError += "Veuillez remplir le champs adversaire! \n";
					}
					if (listViewEquipe.getItems().isEmpty()) {
						messageError += "Veuillez ajouter des membres dans l'équipe! \n";
					}
					if (messageError.length() > 0) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Message d'erreur");
						alert.setHeaderText("Erreur");
						alert.setContentText(messageError);

						alert.showAndWait();

					} else {
						String[] tab = olequipe.toArray(new String[olequipe.size()]);
						Match match = new Match(choixPhase.getSelectionModel().getSelectedItem(), tfContre.getText(),
								tab);

						listeMatch.put(choixPhase.getSelectionModel().getSelectedItem(), match);

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information");
						alert.setHeaderText("Message d'information");
						alert.setContentText("phase :" + choixPhase.getSelectionModel().getSelectedItem()
								+ "\nAdversaire :" + tfContre.getText() + "\n Selection :" + listViewEquipe.getItems());

						alert.showAndWait();
					}
				}
			});

			menumatch.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}

			});

			menumatch.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					RadioMenuItem var = (RadioMenuItem) matchs.getSelectedToggle();
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText("Message d'information");
					alert.setContentText("phase : " + var.getText() + "\nAdversaire :"
							+ listeMatch.get(var.getText()).getAdversaire() + "\n Selection :"
							+ listeMatch.get(var.getText()).getComposition());

					alert.showAndWait();

				}

			});

			Quitter.setOnAction(t -> Platform.exit());
			/*
			 * Quitter.setOnAction(new EventHandler<ActionEvent>() {
			 * 
			 * @Override public void handle(ActionEvent actionEvent) { Platform.exit(); }
			 * });
			 * 
			 */

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
