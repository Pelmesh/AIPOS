import React, { Component } from "react";
import { Route, NavLink, HashRouter } from "react-router-dom";

import CarList from './CarList';
import OwnerList from './OwnerList';
import CheckList from './CheckList';
import CarEdit from './CarEdit';
import OwnerEdit from './OwnerEdit';


class Header extends Component {
	render() {
		return (
			<div>
				<HashRouter>
					<nav class="navbar navbar-expand-lg navbar-light ">
						<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
							<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
								<li class="nav-item active">
									<NavLink class="a" to="/check">Check car</NavLink>
								</li>
								<li class="nav-item">
									<NavLink class="ml-5 a" to="/car/">Cars</NavLink>
								</li>
								<li class="nav-item">
									<NavLink class="ml-5 a" to="/owner">Owners</NavLink>
								</li>
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