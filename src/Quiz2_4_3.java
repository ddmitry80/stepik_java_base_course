public class Quiz2_4_3 {

    private static String printTextPerRole(String[] roles, String[] textLines) {
        //String r = "";
        String ts = "";
        StringBuffer r = new StringBuffer();
        for (String name: roles) {
            //System.out.println(name+":");
            //r = r.concat(name + ":\n");
            r.append(name.concat(":\n"));
            for (int i=0; i<textLines.length; i++) {
                if (textLines[i].startsWith(name+":")) {
                    //System.out.println((i+1)+") " + textLines[i].substring(name.length()+2));
                    //r = r.concat( (i+1)+") " + textLines[i].substring(name.length()+2) + "\n" );
                    //r = r.concat(String.valueOf(i+1)).concat(") ").concat(textLines[i].substring(name.length()+2)).concat("\n");
                    r.append(String.valueOf(i+1).concat(") ").concat(textLines[i].substring(name.length()+2)).concat("\n"));
                }
            }
            //System.out.println();
            //r = r.concat("\n");
            r.append("\n");
        }
        return r.toString();
    };

    public static void main(String[] args) {
        String[] roles = new String[] {
                        "Городничий",
                        "Аммос Федорович",
                        "Артемий Филиппович",
                        "Лука Лукич"
        };
        String[] textLines = new String[] {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
        System.out.println(Quiz2_4_3.printTextPerRole(roles, textLines));
    }

}
