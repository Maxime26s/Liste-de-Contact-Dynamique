public class Telephone{
    private String info;
    private String num;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public static Telephone creerTelephone() {
        Telephone telephone = new Telephone();
        System.out.print("À quoi correspond ce numéro (cellulaire, maison, travail, …) ? ");
        telephone.info = Liste.sc.next();
        System.out.print("Quel est le numéro ? ");
        telephone.num = Liste.sc.next();
        return telephone;
    }

    public void modifierTelephone() {
        String input;
        System.out.print("  " + info + " (" + num + ") : ");
        input = Liste.sc.nextLine().trim();
        if (!input.equals("")) {
            num=input;
        }
    }
}