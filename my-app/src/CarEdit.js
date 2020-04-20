import React, { Component } from "react";
import axios from "axios";
import useParams from "react-router-dom";
import { Link, Route, NavLink,HashRouter,Switch,Redirect  } from "react-router-dom";

class CarEdit extends Component {
	refactorCar   = () => {
		const id = this.props.match.params.id;
		const url = "http://localhost:8080/car/"+id;
		var modelAxios = this.state.modelCar;
		var numberAxios = this.state.numberCar;
		var vinAxios = this.state.vinCar;		
    	
    	const { cars } = this.state;
		
		if(modelAxios===""){
			modelAxios=cars['0']['modelCar'];
		}
		if(numberAxios===""){
			numberAxios=cars['0']['number'];
		}
		if(vinAxios===""){
			vinAxios=cars['0']['vin'];
		}
		console.log(modelAxios,numberAxios,vinAxios)
    	try {
 			const response =  axios.put(url, { idCar: id , modelCar: modelAxios, number: numberAxios, vin: vinAxios  } );
  			console.log('👉 Returned data:', response);
		} catch (e) {
  			console.log(`😱 Axios request failed: ${e}`);
		}
		this.setState({
  			modelCar: '',
           	numberCar: '',
           	vinCar: ''
		});
		setTimeout(() => {
  			this.componentWillMount();
			this.render();
		}, 500);
  	}

	constructor(props) {		
        super(props);
        this.state = {
           	cars: [],
           	modelCar: '',
           	numberCar: '',
           	vinCar: ''
        };

        this.handleModelreactChange = this.handleModelreactChange.bind(this);
		this.handleNumberCarChange = this.handleNumberCarChange.bind(this);
		this.handleVinCarChange = this.handleVinCarChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
    }


	handleModelreactChange(event) {
  		console.log('handleEmailChange', this);
  		this.setState({modelCar: event.target.value});
	}

	handleNumberCarChange(event) {
  		console.log('handleNumberChange', this);
  		this.setState({numberCar: event.target.value});
	}

	handleVinCarChange(event) {
  		console.log('handleVinChange', this);
  		this.setState({vinCar: event.target.value});
	}

	handleSubmit(event) {
	  event.preventDefault();
	}


    componentWillMount() {
    	const id= this.props.match.params.id;
    	const url="http://localhost:8080/car/"+id;
        fetch(url)
          .then(response => response.json())
          .then(data => this.setState({ cars: data }));          
    }
	render(){
		const { cars } = this.state;
        return(
        	<div>
        		<form onSubmit={this.handleSubmit} class="form-inline">
        			{cars.map(item =>
        				<div>
        					<input onChange={this.handleModelreactChange} type="text" placeholder={`${item.modelCar}`} value={this.state.modelCar} name="modelCar" class="form-control mr-2 mb-2 "/>
        					<input onChange={this.handleNumberCarChange} type="text" placeholder={`${item.number}`} value={this.state.numberCar} name="number" class="form-control mr-2 mb-2 "/>
			            	<input onChange={this.handleVinCarChange} type="text" placeholder={`${item.vin}`} value={this.state.vinCar} name="vinCar" class="form-control mr-2 mb-2" />	  
			            	<button onClick={this.refactorCar}  class="btn-primary btn mr-2 mb-2 ">Изменить</button>
			            </div> 			
        			)}
        		</form>
    		</div>	
        )
    }
} 

export default CarEdit; 