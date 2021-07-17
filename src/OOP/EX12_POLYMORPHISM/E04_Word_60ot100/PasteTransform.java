package OOP.EX12_POLYMORPHISM.E04_Word_60ot100;

public class PasteTransform implements TextTransform {
    private CutTransform cutTransform;

    public PasteTransform(CutTransform cutTransform) {
        this.cutTransform = cutTransform;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex, cutTransform.getLastCut().toString());
    }
}
