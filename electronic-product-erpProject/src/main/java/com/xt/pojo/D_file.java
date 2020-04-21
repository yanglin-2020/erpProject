package com.xt.pojo;
/**
 * 产品档案
 * @author yl
 */
public class D_file {
	private int id;//
	private String product_id;//产品编号
	private String product_name;//产品名称
	private String factory_name;//制造商
	private String first_kind_id;//产品I级分类编号
	private String first_kind_name;//产品I级分类名称
	private String second_kind_id;//产品II级分类编号
	private String second_kind_name;//产品II级分类名称
	private String third_kind_id;//产品III级分类编号
	private String third_kind_name;//产品III级分类名称
	private String product_nick;//产品简称
	private String type;//用途类型Y001-1: 商品Y001-2: 物料
	private String product_class;//档次级别 D001-1: 高档  D001-2: 中档	 D001-3: 低档
	private String personal_unit;//计量单位
	private String personal_value;//计量值
	private String provider_group;//供应商集合
	private String warranty;//保修期
	private String 	twin_name;//替代品名称
	private String 	twin_id;//替代品编号
	private String lifecycle;//生命周期
	private double list_price;//市场单价
	private double cost_price;//计划成本单价
	private double real_cost_price;//成本单价
	private String amount_unit;//单位
	private String product_describe;//产品描述
	private String responsible_person;//产品经理
	private String register;//登记人
	private String register_time;//建档时间
	private String checker;//复核人
	private String check_time;//复核时间
	private String check_tag;//审核标志S001-0: 等待审核 S001-1: 审核通过 S001-2: 审核不通过
	private String changer;//变更人
	private String change_time;//变更时间
	private String change_tag;//档案变更标志档案变更标志D002-0: 未变更	D002-1: 已变更
	private String price_change_tag;//价格变更标志J001-0：未变更 J001-1：已变更
	private int file_change_amount;//档案变更累计
	private String delete_tag;//产品删除标志C001-0: 未删除C001-1: 已删除
	private String design_module_tag;//物料组成标志W001-0: 未设计W001-1: 已设计
	private String design_procedure_tag;//工序组成标志G001-0: 未设计  G001-1: 已设计
	private String design_cell_tag;//库存分配标志K001-0: 未设计K001-1: 已设计
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFactory_name() {
		return factory_name;
	}
	public void setFactory_name(String factory_name) {
		this.factory_name = factory_name;
	}
	public String getFirst_kind_id() {
		return first_kind_id;
	}
	public void setFirst_kind_id(String first_kind_id) {
		this.first_kind_id = first_kind_id;
	}
	public String getFirst_kind_name() {
		return first_kind_name;
	}
	public void setFirst_kind_name(String first_kind_name) {
		this.first_kind_name = first_kind_name;
	}
	public String getSecond_kind_id() {
		return second_kind_id;
	}
	public void setSecond_kind_id(String second_kind_id) {
		this.second_kind_id = second_kind_id;
	}
	public String getSecond_kind_name() {
		return second_kind_name;
	}
	public void setSecond_kind_name(String second_kind_name) {
		this.second_kind_name = second_kind_name;
	}
	public String getThird_kind_id() {
		return third_kind_id;
	}
	public void setThird_kind_id(String third_kind_id) {
		this.third_kind_id = third_kind_id;
	}
	public String getThird_kind_name() {
		return third_kind_name;
	}
	public void setThird_kind_name(String third_kind_name) {
		this.third_kind_name = third_kind_name;
	}
	public String getProduct_nick() {
		return product_nick;
	}
	public void setProduct_nick(String product_nick) {
		this.product_nick = product_nick;
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
	public String getPersonal_unit() {
		return personal_unit;
	}
	public void setPersonal_unit(String personal_unit) {
		this.personal_unit = personal_unit;
	}
	public String getPersonal_value() {
		return personal_value;
	}
	public void setPersonal_value(String personal_value) {
		this.personal_value = personal_value;
	}
	public String getProvider_group() {
		return provider_group;
	}
	public void setProvider_group(String provider_group) {
		this.provider_group = provider_group;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getTwin_name() {
		return twin_name;
	}
	public void setTwin_name(String twin_name) {
		this.twin_name = twin_name;
	}
	public String getTwin_id() {
		return twin_id;
	}
	public void setTwin_id(String twin_id) {
		this.twin_id = twin_id;
	}
	public String getLifecycle() {
		return lifecycle;
	}
	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}
	public double getList_price() {
		return list_price;
	}
	public void setList_price(double list_price) {
		this.list_price = list_price;
	}
	public double getCost_price() {
		return cost_price;
	}
	public void setCost_price(double cost_price) {
		this.cost_price = cost_price;
	}
	public double getReal_cost_price() {
		return real_cost_price;
	}
	public void setReal_cost_price(double real_cost_price) {
		this.real_cost_price = real_cost_price;
	}
	public String getAmount_unit() {
		return amount_unit;
	}
	public void setAmount_unit(String amount_unit) {
		this.amount_unit = amount_unit;
	}
	public String getProduct_describe() {
		return product_describe;
	}
	public void setProduct_describe(String product_describe) {
		this.product_describe = product_describe;
	}
	public String getResponsible_person() {
		return responsible_person;
	}
	public void setResponsible_person(String responsible_person) {
		this.responsible_person = responsible_person;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getCheck_tag() {
		return check_tag;
	}
	public void setCheck_tag(String check_tag) {
		this.check_tag = check_tag;
	}
	public String getChanger() {
		return changer;
	}
	public void setChanger(String changer) {
		this.changer = changer;
	}
	public String getChange_time() {
		return change_time;
	}
	public void setChange_time(String change_time) {
		this.change_time = change_time;
	}
	public String getChange_tag() {
		return change_tag;
	}
	public void setChange_tag(String change_tag) {
		this.change_tag = change_tag;
	}
	public String getPrice_change_tag() {
		return price_change_tag;
	}
	public void setPrice_change_tag(String price_change_tag) {
		this.price_change_tag = price_change_tag;
	}
	public int getFile_change_amount() {
		return file_change_amount;
	}
	public void setFile_change_amount(int file_change_amount) {
		this.file_change_amount = file_change_amount;
	}
	public String getDelete_tag() {
		return delete_tag;
	}
	public void setDelete_tag(String delete_tag) {
		this.delete_tag = delete_tag;
	}
	public String getDesign_module_tag() {
		return design_module_tag;
	}
	public void setDesign_module_tag(String design_module_tag) {
		this.design_module_tag = design_module_tag;
	}
	public String getDesign_procedure_tag() {
		return design_procedure_tag;
	}
	public void setDesign_procedure_tag(String design_procedure_tag) {
		this.design_procedure_tag = design_procedure_tag;
	}
	public String getDesign_cell_tag() {
		return design_cell_tag;
	}
	public void setDesign_cell_tag(String design_cell_tag) {
		this.design_cell_tag = design_cell_tag;
	}
	public D_file() {
		super();
	}
	public D_file(String product_id, String product_name, String factory_name, String first_kind_id,
			String product_nick, String type, String product_class, String personal_unit, String personal_value,
			String warranty, String lifecycle, double list_price, double cost_price, String product_describe,
			String responsible_person, String register) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.factory_name = factory_name;
		this.first_kind_id = first_kind_id;
		this.product_nick = product_nick;
		this.type = type;
		this.product_class = product_class;
		this.personal_unit = personal_unit;
		this.personal_value = personal_value;
		this.warranty = warranty;
		this.lifecycle = lifecycle;
		this.list_price = list_price;
		this.cost_price = cost_price;
		this.product_describe = product_describe;
		this.responsible_person = responsible_person;
		this.register = register;
	}
}
=======
package com.xt.pojo;
/**
 * 产品档案
 * @author yl
 */
public class D_file {
	private int id;//
	private String product_id;//产品编号
	private String product_name;//产品名称
	private String factory_name;//制造商
	private String first_kind_id;//产品I级分类编号
	private String first_kind_name;//产品I级分类名称
	private String second_kind_id;//产品II级分类编号
	private String second_kind_name;//产品II级分类名称
	private String third_kind_id;//产品III级分类编号
	private String third_kind_name;//产品III级分类名称
	private String product_nick;//产品简称
	private String type;//用途类型Y001-1: 商品Y001-2: 物料
	private String product_class;//档次级别 D001-1: 高档  D001-2: 中档	 D001-3: 低档
	private String personal_unit;//计量单位
	private String personal_value;//计量值
	private String provider_group;//供应商集合
	private String warranty;//保修期
	private String 	twin_name;//替代品名称
	private String 	twin_id;//替代品编号
	private String lifecycle;//生命周期
	private double list_price;//市场单价
	private double cost_price;//计划成本单价
	private double real_cost_price;//成本单价
	private String amount_unit;//单位
	private String product_describe;//产品描述
	private String responsible_person;//产品经理
	private String register;//登记人
	private String register_time;//建档时间
	private String checker;//复核人
	private String check_time;//复核时间
	private String check_tag;//审核标志S001-0: 等待审核 S001-1: 审核通过 S001-2: 审核不通过
	private String changer;//变更人
	private String change_time;//变更时间
	private String change_tag;//档案变更标志档案变更标志D002-0: 未变更	D002-1: 已变更
	private String price_change_tag;//价格变更标志J001-0：未变更 J001-1：已变更
	private int file_change_amount;//档案变更累计
	private String delete_tag;//产品删除标志C001-0: 未删除C001-1: 已删除
	private String design_module_tag;//物料组成标志W001-0: 未设计W001-1: 已设计
	private String design_procedure_tag;//工序组成标志G001-0: 未设计  G001-1: 已设计
	private String design_cell_tag;//库存分配标志K001-0: 未设计K001-1: 已设计
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFactory_name() {
		return factory_name;
	}
	public void setFactory_name(String factory_name) {
		this.factory_name = factory_name;
	}
	public String getFirst_kind_id() {
		return first_kind_id;
	}
	public void setFirst_kind_id(String first_kind_id) {
		this.first_kind_id = first_kind_id;
	}
	public String getFirst_kind_name() {
		return first_kind_name;
	}
	public void setFirst_kind_name(String first_kind_name) {
		this.first_kind_name = first_kind_name;
	}
	public String getSecond_kind_id() {
		return second_kind_id;
	}
	public void setSecond_kind_id(String second_kind_id) {
		this.second_kind_id = second_kind_id;
	}
	public String getSecond_kind_name() {
		return second_kind_name;
	}
	public void setSecond_kind_name(String second_kind_name) {
		this.second_kind_name = second_kind_name;
	}
	public String getThird_kind_id() {
		return third_kind_id;
	}
	public void setThird_kind_id(String third_kind_id) {
		this.third_kind_id = third_kind_id;
	}
	public String getThird_kind_name() {
		return third_kind_name;
	}
	public void setThird_kind_name(String third_kind_name) {
		this.third_kind_name = third_kind_name;
	}
	public String getProduct_nick() {
		return product_nick;
	}
	public void setProduct_nick(String product_nick) {
		this.product_nick = product_nick;
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
	public String getPersonal_unit() {
		return personal_unit;
	}
	public void setPersonal_unit(String personal_unit) {
		this.personal_unit = personal_unit;
	}
	public String getPersonal_value() {
		return personal_value;
	}
	public void setPersonal_value(String personal_value) {
		this.personal_value = personal_value;
	}
	public String getProvider_group() {
		return provider_group;
	}
	public void setProvider_group(String provider_group) {
		this.provider_group = provider_group;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getTwin_name() {
		return twin_name;
	}
	public void setTwin_name(String twin_name) {
		this.twin_name = twin_name;
	}
	public String getTwin_id() {
		return twin_id;
	}
	public void setTwin_id(String twin_id) {
		this.twin_id = twin_id;
	}
	public String getLifecycle() {
		return lifecycle;
	}
	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}
	public double getList_price() {
		return list_price;
	}
	public void setList_price(double list_price) {
		this.list_price = list_price;
	}
	public double getCost_price() {
		return cost_price;
	}
	public void setCost_price(double cost_price) {
		this.cost_price = cost_price;
	}
	public double getReal_cost_price() {
		return real_cost_price;
	}
	public void setReal_cost_price(double real_cost_price) {
		this.real_cost_price = real_cost_price;
	}
	public String getAmount_unit() {
		return amount_unit;
	}
	public void setAmount_unit(String amount_unit) {
		this.amount_unit = amount_unit;
	}
	public String getProduct_describe() {
		return product_describe;
	}
	public void setProduct_describe(String product_describe) {
		this.product_describe = product_describe;
	}
	public String getResponsible_person() {
		return responsible_person;
	}
	public void setResponsible_person(String responsible_person) {
		this.responsible_person = responsible_person;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getCheck_tag() {
		return check_tag;
	}
	public void setCheck_tag(String check_tag) {
		this.check_tag = check_tag;
	}
	public String getChanger() {
		return changer;
	}
	public void setChanger(String changer) {
		this.changer = changer;
	}
	public String getChange_time() {
		return change_time;
	}
	public void setChange_time(String change_time) {
		this.change_time = change_time;
	}
	public String getChange_tag() {
		return change_tag;
	}
	public void setChange_tag(String change_tag) {
		this.change_tag = change_tag;
	}
	public String getPrice_change_tag() {
		return price_change_tag;
	}
	public void setPrice_change_tag(String price_change_tag) {
		this.price_change_tag = price_change_tag;
	}
	public int getFile_change_amount() {
		return file_change_amount;
	}
	public void setFile_change_amount(int file_change_amount) {
		this.file_change_amount = file_change_amount;
	}
	public String getDelete_tag() {
		return delete_tag;
	}
	public void setDelete_tag(String delete_tag) {
		this.delete_tag = delete_tag;
	}
	public String getDesign_module_tag() {
		return design_module_tag;
	}
	public void setDesign_module_tag(String design_module_tag) {
		this.design_module_tag = design_module_tag;
	}
	public String getDesign_procedure_tag() {
		return design_procedure_tag;
	}
	public void setDesign_procedure_tag(String design_procedure_tag) {
		this.design_procedure_tag = design_procedure_tag;
	}
	public String getDesign_cell_tag() {
		return design_cell_tag;
	}
	public void setDesign_cell_tag(String design_cell_tag) {
		this.design_cell_tag = design_cell_tag;
	}
}
>>>>>>> branch 'master' of https://github.com/yanglin-2020/erpProject.git
