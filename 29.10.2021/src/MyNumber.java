public class MyNumber<T extends Number> {
    private T value;

    public MyNumber(T value) {
        this.value = value;
    }

    public Integer getValueOfInteger() {
        return this.value.intValue();
    }
    public Float getValueOfFloat() {
        return this.value.floatValue();
    }
    public Long getValueOfLong() {
        return this.value.longValue();
    }
    public Double getValueOfDouble() {
        return this.value.doubleValue();
    }
    public String getValueOfString() {
        return this.value.toString();
    }
    public Short getValueOfShort() {
        return this.value.shortValue();
    }
    public Byte getValueOfByte() {
        return this.value.byteValue();
    }

    public void setValue(T value) {
        if (value.getClass() == Number.class){
            this.value = value;
        }
    }
}