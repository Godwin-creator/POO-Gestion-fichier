package gestion.fichier;

import gestion.fichier.cli.Commande;
import gestion.fichier.cli.ParseurCommande;
import gestion.fichier.cli.Navigateur;
import gestion.fichier.metier.Fichier;
import java.util.Scanner;

/*
    Auteur : EDOH BEDI Komi Godwin
    File : Main
    Created : 24/02/2026
 */

public class Main  {
    private static Scanner clavier = new Scanner(System.in);
    private static ParseurCommande parseur = new ParseurCommande();

    public static void main(String[] args) {
        System.out.println("\t\t\t---INVITE DE COMMANDE / Gestion Fichier ---");

        try {
            Fichier.restaurer();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());

        while (true) {
            String chemin = "C:\\Users\\EDOHB" + Navigateur.getInstance().getRepertoireCourant().getNomComplet() + ">";

            System.out.println(chemin);
            String strCmde = clavier.nextLine();
            Commande commande = parseur.parser(strCmde);
            commande.executer();
        }
    }
}