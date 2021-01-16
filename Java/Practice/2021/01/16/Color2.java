enum Color2 {
    RED{
      public String getColor() {
          return "red";
      }
    },
    BLUE{
        public String getColor() {
            return "blue";
        }
    },
    GREEN{
        public String getColor() {
            return "green";
        }
    };
    public abstract String getColor();
}
