<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<%=path%>/css/css.css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		var eid = ${param.eid};
		$.post("toUpdate.do","eid="+eid,function(data){
			var list = data.list;
			var e = data.e;
			var str = " <option value='0'>请选择注册专业</option>";
			for(var i in list){
				str+="<option value='"+list[i].pid+"'>"+list[i].pname+"</option>";
			}
			$("[name='pid1']").html(str)
			$("[name='pid2']").html(str)
			
			$("[name='pid1']").val(e.pid1)
			$("[name='pid2']").val(e.pid2)
			
			$("[name='ename']").val(e.ename)
			$("[name='eid']").val(e.eid)
			$("[name='area']").val(e.area)
			$("[name='sex']").each(function(){
				if(this.value == e.sex){
					this.checked = true;
				}
			})
			$("[name='gboos']").val(e.gboos)
			$("[name='spname']").val(e.spname)
			$("[name='registnum']").val(e.registnum)
			$("[name='num']").val(e.num)
			$("[name='time']").val(e.time)
		})
	})
	function update() {
		$.post("update.do",$("form").serialize(),function(date){
			if(date){
				alert("修改成功")
				location.href="list.do";
			}
		})
	}
</script>
</head>
<body>
	<form>
		<input type="hidden" name="eid">
		<table>
			<tr>
				<td>姓名</td>
				<td>
					<input type="text" name="ename">
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="sex" value="男">男
					<input type="radio" name="sex" value="女">女
				</td>
			</tr>
			<tr>
				<td>省市</td>
				<td>
					<input type="text" name="area">
				</td>
			</tr>
			<tr>
				<td>申请注册单位</td>
				<td>
					<input type="text" name="gboos">
				</td>
			</tr>
			<tr>
				<td>所学专业</td>
				<td>
					<input type="text" name="spname">
				</td>
			</tr>
			<tr>
				<td>申请注册专业1</td>
				<td>
					<select name="pid1">
						<option value="0">请选择注册专业</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>申请注册专业2</td>
				<td>
					<select name="pid2">
						<option value="0">请选择注册专业</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>执业资格证书编号</td>
				<td>
					<input type="text" name="num">
				</td>
			</tr>
			<tr>
				<td>注册号</td>
				<td>
					<input type="text" name="registnum">
				</td>
			</tr>
			<tr>
				<td>有效期</td>
				<td>
					<input type="text" name="time">
				</td>
			</tr>
			<tr>
				<td colspan="10">
					<input type="button" value="保存" onclick="update()">
					<input type="button" value="返回" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>