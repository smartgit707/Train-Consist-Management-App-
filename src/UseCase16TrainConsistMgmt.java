public class UseCase16TrainConsistMgmt {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // ---- Goods Bogie Model ----
    static class GoodsBogie {
        private String shape;   // Rectangular or Cylindrical
        private String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargoType) {
            try {
                // Validation rule
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargoType.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException(
                            "Unsafe assignment: Petroleum cannot be loaded in Rectangular bogie."
                    );
                }

                // Safe assignment
                this.cargo = cargoType;
                System.out.println("Cargo assigned successfully: " + cargoType);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Validation completed for bogie: " + shape);
            }
        }

        public String getCargo() {
            return cargo;
        }
    }

    // ---- MAIN METHOD ----
    public static void main(String[] args) {

        // Safe case
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        cylindricalBogie.assignCargo("Petroleum");

        System.out.println();

        // Unsafe case
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        rectangularBogie.assignCargo("Petroleum");

        System.out.println();

        // Program continues
        rectangularBogie.assignCargo("Grain");
    }
}