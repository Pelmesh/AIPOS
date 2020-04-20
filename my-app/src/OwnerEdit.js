import React, { Component } from "react";
import axios from "axios";
import useParams from "react-router-dom";
import { NavLink,HashRouter  } from "react-router-dom";


class OwnerEdit extends Component {

	refactorOwner   = () => {
		const id = this.props.match.params.id;
		const url = "http://localhost:8080/owner/"+id;
		var nameAxios = this.state.ownerName;
		var yearAxios = this.state.year;			
    const { owners } = this.state;
		console.log(owners);
		if(nameAxios===""){
			nameAxios=owners['0']['ownerName'];
		}
		if(yearAxios===""){
			yearAxios=owners['0']['year'];
		}
    try {
 			const response =  axios.put(url, { idOwner: id , ownerName: nameAxios, year: yearAxios } );
      console.log('👉 Returned data:', response);
		} catch (e) {
  			console.log(`😱 Axios request failed: ${e}`);
		}
		
    this.setState({
  			ownerName: '',
        year: ''
		});
		setTimeout(() => {
  		this.componentWillMount();
			this.render();
		}, 500);
  	
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
  		this.setState({ownerName: event.target.value});
	}

	handleYearChange(event) {
  		this.setState({year: event.target.value});
	}


	handleSubmit(event) {
	  event.preventDefault();
	}


  componentWillMount() {
  	const id= this.props.match.params.id;
  	const url="http://localhost:8080/owner/"+id;
    fetch(url)
      .then(response => response.json())
      .then(data => this.setState({ owners: data }));          
    }
	render(){
		const { owners } = this.state;
        return(
        	<div>
        		<form onSubmit={this.handleSubmit} class="form-inline">
        			{owners.map(item =>
        				<div>
        					<input onChange={this.handleOwnerNameChange} type="text" placeholder={`${item.ownerName}`} value={this.state.ownerName} name="ownerName" class="form-control mr-2 mb-2 "/>
        					<input onChange={this.handleYearChange} type="text" placeholder={`${item.year}`} value={this.state.year} name="year" class="form-control mr-2 mb-2 "/>	  
			            <button onClick={this.refactorOwner}  class="btn-primary btn mr-2 mb-2 ">Изменить</button>
			            </div> 			
        			)}
        		</form>
    		</div>	
        )
    }
} 

export default OwnerEdit; 