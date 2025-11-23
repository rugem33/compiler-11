public class MiniCLabelList {
    enum Labels {
        l0("l0"),
        l1("l1"),
        l2("l2"),
        l3("l3"),
        l4("l4"),
        l5("l5"),
        l6("l6"),
        l7("l7"),
        l8("l8"),
        l9("l9"),
        l10("l10"),
        l11("l11"),
        l12("l12"),
        l13("l13"),
        l14("l14"),
        l15("l15");

        private final String label;

        Labels(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private static int labelsNum = -1;

    public static String getLabels() {
        if (labelsNum + 1 >= Labels.values().length) {
            throw new IllegalStateException("더 이상 사용할 수 있는 labels가 없습니다");
        }
        labelsNum++;
        return Labels.values()[labelsNum].getLabel();
    }

}