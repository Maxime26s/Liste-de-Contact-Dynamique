import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Liste {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, Contact> map=new HashMap<>();
        Queue<Contact> queue=new LinkedList<>();
        int choixInt;
        System.out.println("Bienvenue!");
        while (true) {
            choixInt=listeChoix();
            choixSwitch(choixInt,map,queue);
        }
    }
    public static int listeChoix(){
        System.out.println();
        System.out.println(" 1- Ajouter un contact");
        System.out.println(" 2- Modifier un contact");
        System.out.println(" 3- Afficher les contacts");
        System.out.println(" 4- Supprimer un contact");
        System.out.println(" 5- Ajouter un contact à la liste de rappels");
        System.out.println(" 6- Voir la liste de rappels");
        System.out.println(" 7- Quitter");
        System.out.print("Que souhaitez-vous faire ? ");
        System.out.println();
        return sc.nextInt();
    }
    public static void choixSwitch(int choixInt,HashMap<String,Contact> map,Queue<Contact> queue){
        String choixString;
        switch (choixInt) {
            case 1:
                Contact tempContact=Contact.ajouterContact();
                map.put(tempContact.getPrenom(),tempContact);
                break;
            case 2:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    map.get(choixString).modifierContact();
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 3:
                map.forEach((k,contact)-> {
                    //CONTACT
                    contact.afficherContact();
                });
                System.out.print("------------");
                break;
            case 4:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    map.remove(choixString);
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 5:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    queue.add(map.get(choixString));
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 6:
                if(queue.peek()!=null){
                    System.out.println("Le contact a rappelé au plus tôt est "+queue.peek().getPrenom()+" "+queue.poll().getNom());
                }
                else{
                    System.out.println("Il n'y a aucun contact à rappeler");
                }
                break;
            case 7:
                System.out.println("Au revoir !");
                System.exit(0);
                break;
            default:
                System.out.println("ERREUR: Entrez un choix valide (entre 1 et 4)");
                break;
        }
    }
}