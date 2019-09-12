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
		$.post("findAllProfession.do",function(data){
			var str = " <option value='0'>请选择注册专业</option>";
			for(var i in data){
				str+="<option value='"+data[i].pid+"'>"+data[i].pname+"</option>";
			}
			$("[name='pid']").html(str)
		})
	})
	function qx() {
		$("[name='eid']").prop("checked",!$("[name='eid']").prop("checked"));
	}
	function delAll() {
		var eids = $("[name='eid']:checked").map(function(){
			return $(this).val();
		}).get().join(",");
		$.post("delAllEngineer.do","eids="+eids,function(data){
			if(data){
				alert("删除成功")
				location.href="list.do";
			}
		})
	}
	function delByEid(eid) {
		$.post("delByEid.do","eid="+eid,function(data){
			if(data){
				alert("删除成功")
				location.href="list.do";
			}
		})
	}
</script>
</head>
<body>
	<form action="list.do" method="post">
		姓名：<input type="text" name="sname">
		省市：<input type="text" name="areaname">
		注册专业：<select name="pid">
		             <option value="0">请选择注册专业</option>
				</select>
				<input type="submit" value="查询">
	</form>
	<input type="button" value="批量删除" onclick="delAll()"> 
	<table>
		<tr>
			<td><input type="checkbox" onclick="qx()">全选/全不选</td>
			<td>ID</td>
			<td>姓名</td>
			<td>性别</td>
			<td>省市</td>
			<td>申请注册单位</td>
			<td>所学专业</td>
			<td>申请注册专业1</td>
			<td>申请注册专业2</td>
			<td>执业资格证书编号</td>
			<td>注册号</td>
			<td>有效期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list}" var="l">
			<tr>
				<td><input type="checkbox" name="eid" value="${l.eid}"></td>
				<td>${l.eid}</td>
				<td>${l.ename}</td>
				<td>${l.sex}</td>
				<td>${l.area}</td>
				<td>${l.gboos}</td>
				<td>${l.spname}</td>
				<td>${l.pname1}</td>
				<td>${l.pname2}</td>
				<td>${l.num}</td>
				<td>${l.registnum}</td>
				<td>${l.time}</td>
				<td>
					<input type="button" value="删除" onclick="delByEid(${l.eid})">
					<input type="button" value="编辑" onclick="location.href='update.jsp?eid=${l.eid}'">
				</td>
			</tr>	
		</c:forEach>
		<tr>
			<td colspan="100">
				<a href="list.do?pageNum=1"><input type="button" value="首页"></a>
				<a href="list.do?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1}"><input type="button" value="上一页"></a>
				当前${page.pageNum}页/${page.pages}页
				<a href="list.do?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1}"><input type="button" value="下一页"></a>
				<a href="list.do?pageNum=${page.pages}"><input type="button" value="尾页"></a>
			</td>
		</tr>
	</table>
</body>
</html>