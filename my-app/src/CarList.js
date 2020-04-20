import React, { Component } from "react";
import axios from "axios";
import { NavLink,HashRouter } from "react-router-dom";


class CarList extends Component {
	
	handleClick   = () => {
		//console.log(this.state.model,this.state.number,this.state.vin);
    	//console.log('значение this:', this);
    	try {
 			const response =  axios.post('http://localhost:8080/car', { modelCar: this.state.model,vin: this.state.vin ,number: this.state.number  } );
  			//console.log('👉 Returned data:', response);
		} catch (e) {
  			//console.log(`😱 Axios request failed: ${e}`);
		}
		this.updateWindow();
  	}

  	deleteCar = (event) =>{
    	const id = event.target.id;
  		const url = "http://localhost:8080/car/"+id;
  		try {
 			const response =  axios.delete(url, { idCar: id } );
  			console.log('👉 Returned data:', response);
		} catch (e) {
  			console.log(`😱 Axios request failed: ${e}`);
		}
		this.updateWindow();
  	}

  	updateWindow(){
  		this.setState({
  			model: '',
  			vin: '',
  			number: ''
		});
		setTimeout(() => {
  			this.componentWillMount();
			this.render();
		}, 1000);
  	}

	constructor(props) {	
        super(props);
        this.state = {
        	cars: [],
         	model: '',
           	number: '',
           	vin: ''
        };
        this.handleModelChange = this.handleModelChange.bind(this);
		this.handleNumberChange = this.handleNumberChange.bind(this);
		this.handleVinChange = this.handleVinChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
    }

	handleModelChange(event) {
  		this.setState({model: event.target.value});
	}

	handleNumberChange(event) {
  		this.setState({number: event.target.value});
	}

	handleVinChange(event) {
  		this.setState({vin: event.target.value});
	}

	handleSubmit(event) {
	  event.preventDefault();
	}

    componentWillMount() {
        fetch("http://localhost:8080/car")
          .then(response => response.json())
          .then(data => this.setState({ cars: data }));
    }
	render(){
		const { cars } = this.state;
		//console.log(this.state.cars);
        return(
        	<div>
	        	<div>
	        		<form onSubmit={this.handleSubmit} class="form-inline">
	            		<div class="form-group mx-sm-3 mb-2 ml-2">
			                <input class="form-control mb-2 mr-2" type="text" name="modelCar" placeholder="Модель" value={this.state.model} onChange={this.handleModelChange}/>  
			                <input class="form-control mb-2 mr-2" type="text" name="vin" placeholder="Vin" value={this.state.vin} onChange={this.handleVinChange}/>
			                <input class="form-control mb-2 mr-2" type="text" name="number" placeholder="Номер" value={this.state.number} onChange={this.handleNumberChange}/>
			                <button onClick={this.handleClick} class="btn btn-primary mb-2">Добавить</button>
	            		</div> 
	            	</form>		

	    		</div>
    			<div>
	    		<table class="table table-hover">
	        		<thead>
			            <tr>
			                <th>ID</th>
			                <th>Модель</th>
			                <th>VIN</th>
			                <th>Номер</th>
			                <th>Изменить</th>
			                <th>Удалить</th>
			            </tr>
	        		</thead>
	       			<tbody>
		       			<HashRouter>
			            	{cars.map(item =>
				                <tr key={item.idCar}>
				                    <td>{item.idCar}</td>
				                    <td>{item.modelCar}</td>
				                    <td>{item.vin}</td>
				                    <td>{item.number}</td>
				                    <td><NavLink  class=""  to={`/carEdit/${item.idCar}`}>Изменить</NavLink></td>
				                    <td><button onClick={this.deleteCar} name={`${item.idCar}`}  id={`${item.idCar}`} class="btn btn-primary mb-2">Удалить</button></td>				                   
				                </tr>
							)}
						</HashRouter>	
	        		</tbody>
	    		</table>
    			</div>
    		</div>	
        )
    }
} 


export default CarList; 