//This should be placed in a class that extends ItemModelProvider
private void ModelInHandFlatInGUI(Item item) {
  ResourceLocation itemLoc = BuiltInRegistries.ITEM.getKey(item);

  this.getBuilder(item.toString() + "_2d")
    .parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated")))
    .texture("layer0", ResourceLocation.fromNamespaceAndPath(itemLoc.getNamespace(), "item/" + itemLoc.getPath() + "_2d"));

  this.getBuilder(item.toString()).customLoader(SeparateTransformsModelBuilder::begin)
    .base(new ItemModelBuilder(modLoc("item"), existingFileHelper)
      .parent(new ModelFile.UncheckedModelFile(
        ResourceLocation.fromNamespaceAndPath(itemLoc.getNamespace(), "item/" + itemLoc.getPath() + "_3d"))))
    .perspective(ItemDisplayContext.GUI, new ItemModelBuilder(modLoc("item"), existingFileHelper)
      .parent(new ModelFile.UncheckedModelFile(
        ResourceLocation.fromNamespaceAndPath(itemLoc.getNamespace(), "item/" + itemLoc.getPath() + "_2d"))));
}
