document.addEventListener('DOMContentLoaded', function() {

	$(".card").hide();
	
	document.querySelector('#btn').addEventListener('click', () => load_search());
	document.querySelector('#logout').addEventListener('click', () => load_logout());
	
});

function load_search(){
	
	let book;
	let name = $('#search').val();
	
	book = {
		name : name
	}
	
	$.ajax({
		type: "POST",
		data: book,
		url: "/bookstore/search/list",
		success: function( result ){
			
			$("thead").show();
			$("tbody").show();
			$("tbody").empty();
			$(".card").hide();
			$(".card-body").empty();
			
			result.forEach( book => {
				
				const labeltitle = document.createElement('label');
				const labelrank = document.createElement('label');
				const td1 = document.createElement('td');
				const td2 = document.createElement('td');
				const td3 = document.createElement('td');
				const button = document.createElement('input');
				const tr = document.createElement('tr');
			
				
				labeltitle.setAttribute('id',  book.name);
				labelrank.setAttribute('id',  book.ranking);
				button.setAttribute('value', 'details');
				button.setAttribute('type', 'submit');
				button.setAttribute('class', 'btn btn-warning right');
				
				td1.append(button);
				td2.append(labeltitle);
				td3.append(labelrank);
				
				labeltitle.innerHTML = book.name
				labelrank.innerHTML = book.ranking
			
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				$("tbody").append(tr);
				
			});
			
			document.querySelectorAll('.right').forEach( function(a) {
			

				$(a).click(function() {
					let id = $( this ).parent().siblings().children().attr('id');
					
					book = {
						name : id
					}
		
					$.ajax({
						type: "POST",
						data: book,
						url: "/bookstore/search/list",
						success: function( result ){
						
							$("thead").hide();
							$("tbody").hide();
							$(".card").show();
							$(".card-body").empty();
			
							result.forEach( book => {
								
			
								const LabelName = document.createElement('h5');
								const LabelAuthor = document.createElement('h6');
								const LabelOutline = document.createElement('p');
								const LabelRanking = document.createElement('p');
								const LabelPrice = document.createElement('p');
								const LabelQuantity = document.createElement('p');
								const labelName = document.createElement('label');
								const labelOutline = document.createElement('label');
								const labelAuthor = document.createElement('label');
								const labelRanking = document.createElement('label');
								const labelPrice = document.createElement('label');
								const labelQuantity = document.createElement('label');
								
								
								LabelName.setAttribute('class', 'card-title');
								LabelAuthor.setAttribute('class', 'card-subtitle mb-2 text-muted');
								LabelOutline.setAttribute('class', 'card-text');
								LabelRanking.setAttribute('class', 'card-text');
								LabelQuantity.setAttribute('class', 'card-text');
								
								LabelName.append(labelName);
								LabelAuthor.append(labelAuthor);
								LabelOutline.append(labelOutline);
								LabelRanking.append(labelRanking);
								LabelPrice.append(labelPrice);
								LabelQuantity.append(labelQuantity);
								
								labelName.innerHTML = book.name
								labelAuthor.innerHTML = "By : " + book.author
								labelOutline.innerHTML = "Outline : " + book.outline
								labelRanking.innerHTML = "Ranking : " + book.ranking
								labelPrice.innerHTML = "Price : $" + book.price
								labelQuantity.innerHTML = "Remaining : " + book.quantity
							
								$(".card-body").append(LabelName);
								$(".card-body").append(LabelAuthor);
								$(".card-body").append(LabelOutline);
								$(".card-body").append(LabelRanking);
								$(".card-body").append(LabelPrice);
								$(".card-body").append(LabelQuantity);
								
								
							});
							
						}
					});
					
				});
				
			});
			
		}
	});
};

function load_logout(){
	
	$.ajax({
		type: "POST",
		url: "/bookstore/logout",
		success: function( result ){
            window.location.href = "/bookstore";
		}
	});
};