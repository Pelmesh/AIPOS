import React, { Component } from "react";
import { Route, NavLink,HashRouter } from "react-router-dom"; 

import CarList from './CarList';
import OwnerList from './OwnerList';
import CheckList from './CheckList';
import CarEdit from './CarEdit';
import OwnerEdit from './OwnerEdit';


class Header extends Component {
	/*<form action="/logout" method="post" class="form-inline my-2 my-lg-0">
	        <input type="hidden" name="_csrf" value="${_csrf.token}" />
			<input class="butInput my-2 my-lg-0 mr-sm-0 my-sm-0" type="submit" value="Sign Out"/>
		</form>*/
	
	render(){
        return(
        <div>	
	        <HashRouter>
				<nav class="navbar navbar-expand-lg navbar-light ">
					<NavLink class="mr-5"  to="/check">Check car</NavLink>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
	            		<ul class="navbar-nav mr-auto">
	               			<div class="navbar-nav mr-2">
		               			<NavLink class="mr-5" to="/car/">Cars</NavLink>
		               			<NavLink class="mr-5" to="/owner">Owners</NavLink>
	               			</div>
	           			</ul>
	       			</div>
	      	   	</nav>
	    		<div className="content">	
		      		<Route exact path="/" component={CarList} />
		      		<Route path="/car/" component={CarList} />
		      		<Route path="/carEdit/:id" component={CarEdit} />
		      		<Route path="/owner" component={OwnerList} />
		      		<Route path="/ownerEdit/:id" component={OwnerEdit} />
		      		<Route path="/check" component={CheckList} />
				</div>
			</HashRouter>
		</div>	
        )
    }
} 

export default Header; 