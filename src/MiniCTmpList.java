public class MiniCTmpList {
    enum Tmp {
        t0("t0"),
        t1("t1"),
        t2("t2"),
        t3("t3"),
        t4("t4"),
        t5("t5"),
        t6("t6"),
        t7("t7"),
        t8("t8"),
        t9("t9"),
        t10("t10"),
        t11("t11"),
        t12("t12"),
        t13("t13"),
        t14("t14"),
        t15("t15"),
        t16("t16"),
        t17("t17"),
        t18("t18"),
        t19("t19"),
        t20("t20");

        private final String label;

        Tmp(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private static int tmpNum = -1;

    public static String getTmp() {
        if (tmpNum + 1 >= Tmp.values().length) {
            throw new IllegalStateException("더 이상 사용할 수 있는 tmp가 없습니다");
        }
        tmpNum++;
        return Tmp.values()[tmpNum].getLabel();
    }


    public static String getCurrentTmp() {
        return Tmp.values()[tmpNum].getLabel();
    }
}