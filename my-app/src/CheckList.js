import React, { Component } from "react";
import axios from "axios";

class CheckList extends Component {
	
    handleClick   = (event) => {
        var nameAxios = this.state.ownerName;
        var vinAxios = this.state.vin;            
        const { owners } = this.state;
        const { cars } = this.state;
        if(nameAxios===""){
            nameAxios=owners['0']['ownerName'];
        }
        if(vinAxios===""){
            vinAxios=cars['0']['vin'];
        }
        //console.log('значение this:', this);
        try {
            const response =  axios.post('http://localhost:8080/check', { ownerName: nameAxios, vin: vinAxios , result: this.state.result} );
            console.log('👉 Returned data:', response);
        } catch (e) {
            console.log(`😱 Axios request failed: ${e}`);
        }
        this.state = {
            checks: [],
            owners: [],
            cars: [],
            vin: '',
            ownerName: '',
            result: 'Прошел',
        };
        setTimeout(() => {
            this.componentWillMount();
            this.render();
        }, 1000);
    }

    constructor(props) {
        super(props);
        this.state = {
           checks: [],
           owners: [],
           cars: [],
           vin: '',
           ownerName: '',
           result: 'Прошел',
        };
        
        this.handleOwnerNameChange = this.handleOwnerNameChange.bind(this);
        this.handleVinChange = this.handleVinChange.bind(this);
        this.handleResultChange = this.handleResultChange.bind(this);
    }


    handleOwnerNameChange(event) {
        this.setState({ownerName: event.target.value});
    }
    handleVinChange(event) {
        this.setState({vin: event.target.value});
    }
    handleResultChange(event) {
        this.setState({result: event.target.value});
    }

    handleSubmit(event) {
      event.preventDefault();
    }

    componentWillMount() {
        fetch("http://localhost:8080/check")
          .then(response => response.json())
          .then(data => this.setState({ checks: data }));
        fetch("http://localhost:8080/owner")
          .then(response => response.json())
          .then(data => this.setState({ owners: data }));
        fetch("http://localhost:8080/car")
          .then(response => response.json())
          .then(data => this.setState({ cars: data }));
    }
	render(){
		const { checks } = this.state;
        const { owners } = this.state;
        const { cars } = this.state;

        return(
        	<div>
        	   <form onSubmit={this.handleSubmit} class="form-inline">
                    <div  class="form-group mx-sm-3 mb-2 ml-2">
                        <select name="vin" class="form-control mr-2" value={this.state.vin} onChange={this.handleVinChange}>
                            {cars.map(item =>
                                <option>{item.vin}</option>
                            )}
                        </select>
                        <select name="ownerName" class="form-control mr-2" value={this.state.ownerName} onChange={this.handleOwnerNameChange}>
                            {owners.map(item =>
                                <option>{item.ownerName}</option>
                            )}
                        </select>
                        <select name="result" class="form-control mr-2" value={this.state.result} onChange={this.handleResultChange}>
                            <option >Прошел</option>
                            <option>Не прошел</option>
                        </select>
                        <button onClick={this.handleClick} class="btn btn-primary">Добавить</button>
                    </div>
                </form>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>VIN</th>
                            <th>Имя владельца</th>
                            <th>Рзультат</th>
                        </tr>
                    </thead>
                    <tbody>
                        {checks.map(item =>
                            <tr>
                                <td>{item.id_check}</td>
                                <td>{item.vin}</td>
                                <td>{item.ownerName}</td>
                                <td>{item.result}</td>
                            </tr>
                        )}
                    </tbody>
                </table>
    		</div>
        );
    }
} 

export default CheckList; 