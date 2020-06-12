import React, { Component } from "react";
import axios from "axios";
import { NavLink, HashRouter } from "react-router-dom";

class OwnerList extends Component {

    handleClick = () => {
        try {
            const response = axios.post('http://localhost:8080/owner', { ownerName: this.state.ownerName, year: this.state.year })
                .then(response => this.setState({ owners: response.data }));
        } catch (e) {
            console.log(`😱 Axios request failed: ${e}`);
        }
        this.setState({
            ownerName: '',
            year: ''
        });
    }

    deleteOwner = (event) => {
        const id = event.target.id;
        const url = "http://localhost:8080/owner/" + id;
        try {
            const response = axios.delete(url, { idOwner: id })
                .then(response => this.setState({ owners: response.data }));
        } catch (e) {
            console.log(`😱 Axios request failed: ${e}`);
        }
    }

    constructor(props) {
        super(props);
        this.state = {
            owners: [],
            ownerName: '',
            year: ''
        };

        this.handleOwnerNameChange = this.handleOwnerNameChange.bind(this);
        this.handleYearChange = this.handleYearChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleOwnerNameChange(event) {
        this.setState({ ownerName: event.target.value });
    }
    handleYearChange(event) {
        this.setState({ year: event.target.value });
    }
    handleSubmit(event) {
        event.preventDefault();
    }

    componentWillMount() {
        axios.get("http://localhost:8080/owner")
            .then(response => this.setState({ owners: response.data }))
    }

    render() {
        const { owners } = this.state;
        return (
            <div>
                <div>
                    <form onSubmit={this.handleSubmit} class="form-inline">
                        <div class="form-group mx-sm-3 mb-2">
                            <input type="text" class="form-control mr-2" id="inputPassword2" name="ownerName" placeholder="имя" value={this.state.ownerName} onChange={this.handleOwnerNameChange} />
                            <input type="text" class="form-control mr-2" id="inputPassword2" name="year" placeholder="год рождения" value={this.state.year} onChange={this.handleYearChange} />
                            <button onClick={this.handleClick} class="btn btn-primary">Добавить</button>
                        </div>
                    </form>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Имя</th>
                            <th>Год рождения</th>
                            <th>Изменить</th>
                            <th>Удалить</th>
                        </tr>
                    </thead>
                    <tbody>
                        {owners.map(owner => {
                            const { idOwner, ownerName, year } = owner;
                            return (
                                <tr>
                                    <td>{idOwner}</td>
                                    <td>{ownerName}</td>
                                    <td>{year}</td>
                                    <td><NavLink class="" to={`/ownerEdit/${idOwner}`}>Изменить</NavLink></td>
                                    <td><button onClick={this.deleteOwner} name={`${idOwner}`} id={`${idOwner}`} class="btn btn-primary mb-2">Удалить</button></td>
                                </tr>
                            );
                        }
                        )}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default OwnerList; 