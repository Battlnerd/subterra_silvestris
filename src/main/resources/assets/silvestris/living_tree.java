// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class living_tree extends EntityModel<Entity> {
	private final ModelPart body;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart arm0;
	private final ModelPart arm1;
	public living_tree(ModelPart root) {
		this.body = root.getChild("body");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.arm0 = root.getChild("arm0");
		this.arm1 = root.getChild("arm1");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 6).cuboid(-5.0F, 16.0F, -3.0F, 10.0F, 20.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, 36.0F, -3.0F, 10.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, 36.0F, 5.0F, 10.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(20, -8).cuboid(5.0F, 36.0F, -3.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(20, -8).cuboid(-5.0F, 36.0F, -3.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 0.0F));

		ModelPartData leg0 = modelPartData.addChild("leg0", ModelPartBuilder.create().uv(22, 34).cuboid(-5.0F, 0.0F, -2.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(22, 34).mirrored().cuboid(-1.0F, 0.0F, -2.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData arm0 = modelPartData.addChild("arm0", ModelPartBuilder.create().uv(0, 34).mirrored().cuboid(-10.0F, 19.0F, -2.0F, 5.0F, 18.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData arm1 = modelPartData.addChild("arm1", ModelPartBuilder.create().uv(0, 34).cuboid(5.0F, 19.0F, -2.0F, 5.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 58, 58);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg0.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		arm0.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		arm1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}