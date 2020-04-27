package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.D_file;
import com.xt.pojo.SCell;
import com.xt.util.PageUtil;
/**
 * 安全配置单的mapper层
 * @author long
 *
 */
public interface SafeMapper {

	int getDFileCount(@Param("d") D_file d);

	List<D_file> getAllDFileInfo(@Param("page")PageUtil page,@Param("d") D_file d);

	int addSaveSCell(SCell cell);

	int getNofuheDFileCount(SCell s);

	List<SCell> getNofuheDFileInfo(@Param("page")PageUtil page,@Param("s") SCell s);

	SCell getScellByid(String id);

	int fuheSCell(@Param("s")SCell s, @Param("check_tag")String check_tag);

	int getS_cellCount();

	List<SCell> getS_cellInfo(@Param("page")PageUtil page, @Param("s")SCell s);

	int updateSCell(SCell sc);

	int updateD_filedesign_cell_tag(String product_id);

}
