<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>LIGHTBOX EXAMPLE</title>
    
</head>
<body>
	
     <button onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">Lien vers la doc</button>
    <div id="light" class="white_content"><iframe id="pdf" width="99%" height="99%"></iframe></div>
    <div id="fade" class="black_overlay" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"></div>
</body>