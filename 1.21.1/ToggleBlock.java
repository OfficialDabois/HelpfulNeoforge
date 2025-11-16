public class ToggleBlock extends Block {
    public static final Property<Boolean> LIT = BooleanProperty.create("lit");

    public ToggleBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
