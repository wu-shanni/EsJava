
public class Es1_IoT {
    public class LetturaSensore {

        private final Double temperatura;
        private final Integer umiditaPercentuale;
        private final Long timestampUnix;
        private final Boolean batteriaScarica;

        public LetturaSensore(Double temperatura, Integer umiditaPercentuale, Long timestampUnix, Boolean batteriaScarica) {
            if (umiditaPercentuale != null && (umiditaPercentuale < 0 || umiditaPercentuale > 100)) {
                throw new IllegalArgumentException("L'umidità deve essere compresa tra 0 e 100.");
            }

            this.temperatura = temperatura;
            this.umiditaPercentuale = umiditaPercentuale;
            this.timestampUnix = timestampUnix;
            this.batteriaScarica = batteriaScarica;
        }

        public Double getTemperatura() {
            return temperatura;
        }

        public Integer getUmiditaPercentuale() {
            return umiditaPercentuale;
        }

        public Long getTimestampUnix() {
            return timestampUnix;
        }

        public Boolean getBatteriaScarica() {
            return batteriaScarica;
        }

        public String toString() {
            return "LetturaSensore{" +
                    "temperatura=" + temperatura +
                    ", umiditaPercentuale=" + umiditaPercentuale +
                    ", timestampUnix=" + timestampUnix +
                    ", batteriaScarica=" + batteriaScarica +
                    '}';
        }



        public static parsePacchetto(String raw){

        }






    }


    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
          System.out.println("i = " + i);
        }
    }
}