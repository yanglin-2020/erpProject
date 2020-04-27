package com.xt.service;

import com.xt.pojo.D_file;
import com.xt.pojo.SCell;
import com.xt.util.PageDemo;
/**
 * 安全配置单
 * @author long
 *
 */
public interface SafeService {

	PageDemo<D_file> getAllUserInfo(int nowPage, int pageSize, D_file d);

	int addSaveSCell(SCell cell);

	PageDemo<SCell> getNoFuheInfo(int nowPage, int pageSize, SCell d);

	SCell getScellByid(String id);

	int fuheSCell(SCell s, String check_tag);

	PageDemo<SCell> getS_cellInfo(int nowPage, int pageSize, SCell s);

	int updateSCell(SCell sc);

	int updateD_filedesign_cell_tag(String product_id);

}
