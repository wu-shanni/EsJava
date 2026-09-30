import java.util.Optional;

public class Es1_IoT {

    public static class LetturaInvalidaException extends IllegalArgumentException {
        public LetturaInvalidaException(String message) {
            super(message);
        }
    }

    public static class LetturaSensore {

        private final Double temperatura;
        private final Integer umiditaPercentuale;
        private final Long timestampUnix;
        private final Boolean batteriaScarica;

        public LetturaSensore(Double temperatura, Integer umiditaPercentuale, Long timestampUnix, Boolean batteriaScarica) {
            if (umiditaPercentuale != null && (umiditaPercentuale < 0 || umiditaPercentuale > 100)) {
                throw new LetturaInvalidaException("L'umidità deve essere compresa tra 0 e 100. Valore ricevuto: " + umiditaPercentuale);
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



        public static Optional<LetturaSensore> parsePacchetto(String raw) {
            if (raw == null || raw.isBlank()) {
                return Optional.empty();
            }

            Double temp = null;
            Integer umid = null;
            Long ts = null;
            Boolean battLow = null;

            for (String pezzo : raw.split(";")) {
                String[] kv = pezzo.split("=", 2);
                if (kv.length != 2) continue;

                String chiave = kv[0].trim();
                String valore = kv[1].trim();

                try {
                    switch (chiave) {
                        case "temp" -> temp = Double.valueOf(valore);
                        case "umid" -> umid = Integer.valueOf(valore);
                        case "ts" -> ts = Long.valueOf(valore);
                        case "batt_low" -> battLow = Boolean.valueOf(valore);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Errore di parsing per il campo '" + chiave + "' con valore '" + valore + "'. Il campo rimarrà null.");
                }
            }

            return Optional.of(new LetturaSensore(temp, umid, ts, battLow));
        }
    }

    public static void main(String[] args) {








    }
}