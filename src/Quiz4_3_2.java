import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Quiz4_3_2 {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public static interface Sendable {
        String getFrom();
        String getTo();
    }

    /*
     Абстрактный класс,который позволяет абстрагировать логику хранения
     источника и получателя письма в соответствующих полях класса.
     */
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    /*  class UntrustworthyMailWorker  */
    public static class UntrustworthyMailWorker implements MailService {
        RealMailService realMailer;
        MailService[] recipients;

        public UntrustworthyMailWorker(MailService[] recipients) {
            this.recipients = recipients;
            this.realMailer = new RealMailService();
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService rp: recipients) {
                mail = rp.processMail(mail);
            };

            mail = realMailer.processMail(mail);
            return mail;
        }

        public RealMailService getRealMailService() {
            return realMailer;
        }
    }

    /* class Spy */
    public static class Spy implements MailService {

        Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if ((mail.getFrom().equals(AUSTIN_POWERS)) || (mail.getTo().equals(AUSTIN_POWERS))){
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[] {mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});

                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[] {mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    /* class Thief  */
    public static class Thief implements MailService {
        private int minCost;
        private int stolenValue;

        public Thief(int minCost) {
            this.minCost = minCost;
            stolenValue = 0;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getPrice()>=minCost) {
                    stolenValue += ((MailPackage) mail).getContent().getPrice();
                    mail = (Sendable) new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of "+((MailPackage) mail).getContent().getContent(), 0));
                }
            }
            return mail;
        }
    }

    /* class Inspector */
    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            //System.out.println("Inspector begin");
            if (mail instanceof MailPackage) {
                String content = ((MailPackage) mail).getContent().getContent();
                //System.out.println("Inspector debug: " + content);
                if ((content.contains(WEAPONS)) || (content.contains(BANNED_SUBSTANCE))) {
                    //System.out.println("Found weapons or banned substance");
                    throw new IllegalPackageException();
                }
                if (content.contains("stones")) {
                    //System.out.println("Found stones");
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {}

    public static class StolenPackageException extends RuntimeException {}

    // Main program!!!
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Quiz4_3_2.class.getName());
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        Inspector inspector = new Inspector();
        MailService[] variousWorkers = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable[] correspondence = {
                new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("рпакетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance", 99)),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", new Package("tiny bomb", 9000)),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };
        Arrays.stream(correspondence).forEach(parcell -> {
//            if (parcell instanceof MailMessage) {
//                System.out.println("MailMessage");
//            } else {
//                System.out.println("Not MailMessage");
//            }
            try {
                worker.processMail(parcell);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });
    }



}
