<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

     <style type="text/css">

      text {
        font-family: sans-serif;
        font-size: 12px;
        fill: white;
      }

    </style>
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://d3js.org/d3.v3.min.js"></script>
	<script type="text/javascript">
	var count;
function  imp_count_queryByUserType(){
 var ajax_data = $("#count").serialize();
 alert(ajax_data);
 $.ajax({
        type: "get",
        url: "count.do?method=imp_count_queryByUserType",
      
        success: function(data) {
          alert("success");
          var s = decodeURIComponent(data);
          s = decodeURIComponent(s);
          
          s=JSON.parse(s);
        console.log(s.count[0].count1);  
          count = [s.count[0].count0,s.count[0].count1,s.count[0].count2,s.count[0].count3];
          alert(s);
           var w = 300;
      var h = 300;
      var dataset = count;

      var outerRadius = w / 2;
      var innerRadius = w / 3;
      var arc = d3.svg.arc()
              .innerRadius(innerRadius)
              .outerRadius(outerRadius);
      
      var pie = d3.layout.pie();
      
      //Easy colors accessible via a 10-step ordinal scale
      var color = d3.scale.category10();

      //Create SVG element
      var svg = d3.select("body")
            .append("svg")
            .attr("width", w)
            .attr("height", h);
      
      //Set up groups
      var arcs = svg.selectAll("g.arc")
              .data(pie(dataset))
              .enter()
              .append("g")
              .attr("class", "arc")
              .attr("transform", "translate(" + outerRadius + "," + outerRadius + ")");
      
      //Draw arc paths
      arcs.append("path")
          .attr("fill", function(d, i) {
            return color(i);
          })
          .attr("d", arc);
      
      //Labels
      arcs.append("text")
          .attr("transform", function(d) {
            return "translate(" + arc.centroid(d) + ")";
          })
          .attr("text-anchor", "middle")
          .text(function(d) {
            return d.value;
          });
          //window.location.href = "index.jsp";
        }
    });
}

//Width and height
     
</script>
</head>
<body>  
     <form id="count">   
     <button type = "button" onclick = "imp_count_queryByUserType()">imp_count_queryByUserType</button>
     </form>
</body>
</html>