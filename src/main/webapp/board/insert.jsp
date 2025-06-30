<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 등록페이지 -->
<h2>게시판등록</h2>
<table class='enroll-table'>
	<tr>
		<th>제목</th>
		<td colspan=3><input type="text" name="title" value="" /></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3"><input type="text" name="nickname" /></td>
	</tr>
	<tr>
		<th>글내용</th>
		<td colspan="3" style="height: 200px;"><textarea name="content"></textarea>
		</td>
	</tr>
	<tr>
		<th colspan="4">
			<button id="btn">등록</button>
		</th>
	</tr>
</table>
<script>
	$(function() {
		$("#btn").click(function() {
			$.ajax({
				url : "<%=request.getContextPath()%>/board/insert",
				data : {
					title : $(":text[name=title]").val(),
					nickname : $(":text[name=nickname]").val(),
					content : $("textarea[name=content]").val()
				},
				method : "post",
				dataType : "html",
				success : function(data) {
					//alert("게시글등록성공");
					alert(data);
					//$(".outer").append(data);
					$("#list").click();
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
		});
	});
</script>