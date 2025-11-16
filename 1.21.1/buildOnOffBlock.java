public <T extends ToggleBlock> void buildOnOffBlock(T block, boolean nonBlock) {
        String blockName = BuiltInRegistries.BLOCK.getKey(block).getPath();
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);

        if (!nonBlock) {
            variantBuilder
                    .partialState().with(block.LIT, true)
                    .modelForState().modelFile(models().cubeAll(blockName + "_on", modLoc("block/" + blockName + "_on"))).addModel()
                    .partialState().with(block.LIT, false)
                    .modelForState().modelFile(models().cubeAll(blockName + "_off", modLoc("block/" + blockName + "_off"))).addModel();

            simpleBlockItem(block, models().cubeAll(blockName + "_off", modLoc("block/" + blockName + "_off")));
        } else {
            ModelFile modelOff = new ModelFile.ExistingModelFile(
                    modLoc("block/" + blockName + "_off"),
                    this.models().existingFileHelper
            );
            ModelFile modelOn = new ModelFile.ExistingModelFile(
                    modLoc("block/" + blockName + "_on"),
                    this.models().existingFileHelper
            );

            variantBuilder
                    .partialState().with(block.LIT, true)
                    .modelForState().modelFile(modelOn).addModel()
                    .partialState().with(block.LIT, false)
                    .modelForState().modelFile(modelOff).addModel();

            simpleBlockItem(block, modelOff);
        }
    }
