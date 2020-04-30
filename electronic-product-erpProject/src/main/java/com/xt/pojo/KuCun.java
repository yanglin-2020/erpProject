package com.xt.pojo;
/**
 * 库存的动态查询
 * @author yl
 *
 */
public class KuCun {
	private String store_id;//库存编号
	private String product_id; 
	private String product_name;//产品名称
	private int min_amount;//库存报警下限数
	private int max_amount; //库存报警上限数
	private int max_capacity_amount;//最大存储量
	private int amount;//当前存储量
	private String type;//用途
	private String product_class;//产品档次
	private String product_describe;//产品描述
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getMin_amount() {
		return min_amount;
	}
	public void setMin_amount(int min_amount) {
		this.min_amount = min_amount;
	}
	public int getMax_amount() {
		return max_amount;
	}
	public void setMax_amount(int max_amount) {
		this.max_amount = max_amount;
	}
	public int getMax_capacity_amount() {
		return max_capacity_amount;
	}
	public void setMax_capacity_amount(int max_capacity_amount) {
		this.max_capacity_amount = max_capacity_amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduct_class() {
		return product_class;
	}
	public void setProduct_class(String product_class) {
		this.product_class = product_class;
	}
	public String getProduct_describe() {
		return product_describe;
	}
	public void setProduct_describe(String product_describe) {
		this.product_describe = product_describe;
	}
	public KuCun() {
		super();
	}
	public KuCun(String store_id, String product_id, String product_name, int min_amount, int max_amount,
			int max_capacity_amount, int amount, String type, String product_class, String product_describe) {
		super();
		this.store_id = store_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.min_amount = min_amount;
		this.max_amount = max_amount;
		this.max_capacity_amount = max_capacity_amount;
		this.amount = amount;
		this.type = type;
		this.product_class = product_class;
		this.product_describe = product_describe;
	}
	public KuCun(String store_id, String product_id, String product_name, String type, String product_class) {
		super();
		this.store_id = store_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.type = type;
		this.product_class = product_class;
	}
}
