<%@page import="guipackage.GUI"%>
<%@page import="guipackage.SearchBox"%>
<!doctype html>
<html>
	<head>
		<title>Bar Chart</title>
                <meta charset="utf-8">
                <meta name="robots" content="noindex">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
                <link href="css/sidebar.css" rel="stylesheet">
                <link href="css/table.css" rel="stylesheet">
                <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
                <script src="js/sidebar.js"></script>
                <script src="js/Chart.js"></script>
                <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
                <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
                <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="js/Chart.js"></script>
	</head>
        <body>
            <% 
            GUI gui = new GUI();
            out.print(gui.tutorNavigation());
            %>
		<div style="width: 50%">
			<canvas id="canvas" height="450" width="600"></canvas>
		</div>
        <%  
            
            SearchBox search = new SearchBox();
            int showCore1 = Integer.parseInt(search.showCore(1, "119876543"));
            int showCore2 = Integer.parseInt(search.showCore(2, "119876543"));
            int showCore3 = Integer.parseInt(search.showCore(3, "119876543"));
            int showCore4 = Integer.parseInt(search.showCore(4, "119876543"));
            int showCore5 = Integer.parseInt(search.showCore(5, "119876543"));
            int showCore6 = Integer.parseInt(search.showCore(6, "119876543"));
            
            int showBasic1 = Integer.parseInt(search.showBasic(1, "119876543"));
            int showBasic2 = Integer.parseInt(search.showBasic(2, "119876543"));
            int showBasic3 = Integer.parseInt(search.showBasic(3, "119876543"));
            int showBasic4 = Integer.parseInt(search.showBasic(4, "119876543"));
            int showBasic5 = Integer.parseInt(search.showBasic(5, "119876543"));
            int showBasic6 = Integer.parseInt(search.showBasic(6, "119876543"));
            
            int showProfessionalism1 = Integer.parseInt(search.showProfessionalism(1, "119876543"));
            int showProfessionalism2 = Integer.parseInt(search.showProfessionalism(2, "119876543"));
            int showProfessionalism3 = Integer.parseInt(search.showProfessionalism(3, "119876543"));
            int showProfessionalism4 = Integer.parseInt(search.showProfessionalism(4, "119876543"));
            int showProfessionalism5 = Integer.parseInt(search.showProfessionalism(5, "119876543"));
            int showProfessionalism6 = Integer.parseInt(search.showProfessionalism(6, "119876543"));
            
            int showCommunication1 = Integer.parseInt(search.showCommunication(1, "119876543"));
            int showCommunication2 = Integer.parseInt(search.showCommunication(2, "119876543"));
            int showCommunication3 = Integer.parseInt(search.showCommunication(3, "119876543"));
            int showCommunication4 = Integer.parseInt(search.showCommunication(4, "119876543"));
            int showCommunication5 = Integer.parseInt(search.showCommunication(5, "119876543"));
            int showCommunication6 = Integer.parseInt(search.showCommunication(6, "119876543"));
            
            int showKnowledge1 = Integer.parseInt(search.showKnowledge(1, "119876543"));
            int showKnowledge2 = Integer.parseInt(search.showKnowledge(2, "119876543"));
            int showKnowledge3 = Integer.parseInt(search.showKnowledge(3, "119876543"));
            int showKnowledge4 = Integer.parseInt(search.showKnowledge(4, "119876543"));
            int showKnowledge5 = Integer.parseInt(search.showKnowledge(5, "119876543"));
            int showKnowledge6 = Integer.parseInt(search.showKnowledge(6, "119876543"));
            
            
            int my = 25;
            int yours = 25;
        %>

	<script>
        
        var showCore1 = "<%= showCore1 %>"
        var showCore2= "<%= showCore2 %>"
        var showCore3 = "<%= showCore3 %>"
        var showCore4 = "<%= showCore4 %>"
        var showCore5 = "<%= showCore5 %>"
        var showCore6 = "<%= showCore6 %>"
        
        var showBasic1 = "<%= showBasic1 %>"
        var showBasic2 = "<%= showBasic2 %>"
        var showBasic3 = "<%= showBasic3 %>"
        var showBasic4 = "<%= showBasic4 %>"
        var showBasic5 = "<%= showBasic5 %>"
        var showBasic6 = "<%= showBasic6 %>"
        
        var showProfessionalism1 = "<%= showProfessionalism1 %>"
        var showProfessionalism2 = "<%= showProfessionalism2 %>"
        var showProfessionalism3 = "<%= showProfessionalism3 %>"
        var showProfessionalism4 = "<%= showProfessionalism4 %>"
        var showProfessionalism5 = "<%= showProfessionalism5 %>"
        var showProfessionalism6 = "<%= showProfessionalism6 %>"
        
        var showCommunication1 = "<%= showCommunication1 %>"
        var showCommunication2 = "<%= showCommunication2 %>"
        var showCommunication3 = "<%= showCommunication3 %>"
        var showCommunication4 = "<%= showCommunication4 %>"
        var showCommunication5 = "<%= showCommunication5 %>"
        var showCommunication6 = "<%= showCommunication6 %>"
        
        var showKnowledge1 = "<%= showKnowledge1 %>"
        var showKnowledge2 = "<%= showKnowledge2 %>"
        var showKnowledge3 = "<%= showKnowledge3 %>"
        var showKnowledge4 = "<%= showKnowledge4 %>"
        var showKnowledge5 = "<%= showKnowledge5 %>"
        var showKnowledge6 = "<%= showKnowledge6 %>"
        
        
	var barChartData = {
		labels : ["Core","Basic","Professionalism","Knowledge","Communication"],
		datasets : [
			{
				fillColor : "rgba(220,220,220,0.5)",
				strokeColor : "rgba(220,220,220,0.8)",
				highlightFill: "rgba(220,220,220,0.75)",
				highlightStroke: "rgba(220,220,220,1)",
				data : [showCore1, showCore2, showCore3, showCore4, showCore5, showCore6]
			},
			{
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,0.8)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : [showBasic1, showBasic2, showBasic3, showBasic4, showBasic5, showBasic6]
			},
                        {
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,0.8)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : [showProfessionalism1, showProfessionalism2,showProfessionalism3, showProfessionalism4, showProfessionalism5, showProfessionalism6]
			},
                        {
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,0.8)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : [showCommunication1, showCommunication2, showCommunication3, showCommunication4, showCommunication5, showCommunication6 ]
			},
                        {
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,0.8)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : [showKnowledge1, showKnowledge2, showKnowledge3, showKnowledge4, showKnowledge5, showKnowledge6]
			}
                        
		]

	}
	window.onload = function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myBar = new Chart(ctx).Bar(barChartData, {
			responsive : true
		});
	}

	</script>
        
        <%
            out.print(gui.footer());
        %>
	</body>
</html>

