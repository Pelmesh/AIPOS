import React, { Component } from "react";
import axios from "axios";
import { NavLink, HashRouter } from "react-router-dom";


class CarList extends Component {

	handleClick = () => {
		try {
			const response = axios.post('http://localhost:8080/car', { modelCar: this.state.model, vin: this.state.vin, number: this.state.number })
				.then(response => this.setState({ cars: response.data, allCars: response.data }));
		} catch (e) {
			console.log(`😱 Axios request failed: ${e}`);
		}
	}


	deleteCar = (event) => {
		const id = event.target.id;
		const url = "http://localhost:8080/car/" + id;
		try {
			const response = axios.delete(url, { idCar: id })
				.then(response => this.setState({ cars: response.data, allCars: response.data }));
		} catch (e) {
			console.log(`😱 Axios request failed: ${e}`);
		}
	}

	searchWord = (event) => {
		this.state.cars = this.state.allCars;
		setTimeout(() => {
			if (this.state.searchWord === "") {
				return;
			} else {
				this.setState(prevState => ({
					cars: prevState.cars.filter(el => this.searchWordReg(el, this.state.searchWord))
				}));
			}
		}, 1);

	}
	searchWordReg(el, word) {
		if ((el.modelCar.indexOf(word) != -1 || el.number.indexOf(word) != -1 || el.vin.indexOf(word) != -1)) {
			return (true)
		} else {
			return (false)
		}
	}

	constructor(props) {
		super(props);
		this.state = {
			cars: [],
			allCars: [],
			model: '',
			number: '',
			vin: '',
			searchWord: ''
		};
		this.handleModelChange = this.handleModelChange.bind(this);
		this.handleSearchWordChange = this.handleSearchWordChange.bind(this);
		this.handleNumberChange = this.handleNumberChange.bind(this);
		this.handleVinChange = this.handleVinChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleModelChange(event) {
		this.setState({ model: event.target.value });
	}
	handleSearchWordChange(event) {
		this.setState({ searchWord: event.target.value });
	}

	handleNumberChange(event) {
		this.setState({ number: event.target.value });
	}

	handleVinChange(event) {
		this.setState({ vin: event.target.value });
	}

	handleSubmit(event) {
		event.preventDefault();
	}

	getCar() {
		axios.get("http://localhost:8080/car")
			.then(response => this.setState({ cars: response.data, allCars: response.data }))
	}

	componentWillMount() {
		this.getCar();
	}

	render() {
		const { cars, modelList } = this.state;
		return (
			<div>
				<div>
					<form onSubmit={this.handleSubmit} class="form-inline">
						<div class="form-group mx-sm-3 mb-2 ml-2">
							<input class="form-control mb-2 mr-2" type="text" name="modelCar" placeholder="Модель" value={this.state.model} onChange={this.handleModelChange} />
							<input class="form-control mb-2 mr-2" type="text" name="vin" placeholder="Vin" value={this.state.vin} onChange={this.handleVinChange} />
							<input class="form-control mb-2 mr-2" type="text" name="number" placeholder="Номер" value={this.state.number} onChange={this.handleNumberChange} />
							<button onClick={this.handleClick} class="btn btn-primary mb-2">Добавить</button>
							<input class="form-control mb-2 ml-5" type="text" name="Поиск" placeholder="searchWord" onInput={this.searchWord} value={this.state.searchWord} onChange={this.handleSearchWordChange} />
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
								{cars.map(car => {
									const { idCar, modelCar, vin, number } = car;
									return (
										<tr key={idCar}>
											<td>{idCar}</td>
											<td>{modelCar}</td>
											<td>{vin}</td>
											<td>{number}</td>
											<td><NavLink class="" to={`/carEdit/${idCar}`}>Изменить</NavLink></td>
											<td><button onClick={this.deleteCar} name={`${idCar}`} id={`${idCar}`} class="btn btn-primary mb-2">Удалить</button></td>
										</tr>
									);
								}
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

