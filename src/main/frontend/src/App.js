import React, {useState} from "react";
import Books from './Books';
import Employees from './Employees';
import {AppBar, Container, CssBaseline, Link, Toolbar, Typography} from '@material-ui/core';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableRow from '@mui/material/TableRow';


function App() {
    //page = track value, setPage = mutate value
    const [page, setPage] = useState("home");


    return (
        <TableContainer>
            <CssBaseline/>
            <AppBar position="relative">
                <Toolbar>
                    <Typography variant="h6">Spring Boot: Books for Employees</Typography>
                    <Typography variant="h2"><Link href="#" color="#FFF"
                                                   onClick={() => setPage("employees")}>Employees</Link> | <Link
                        href="#" color="#FFF" onClick={() => setPage("books")}>Books</Link> </Typography>
                </Toolbar>
            </AppBar>
            <TableContainer>
                <TableRow key="21">
                    <TableCell key="33">
                        <Container width="100%">
                            <Typography variant="h3"></Typography>
                        </Container>
                        <Container width="100%">
                            {page === "employees" ? <Employees/> : null}
                            {page === "books" ? <Books/> : null}
                        </Container>
                    </TableCell>
                </TableRow>
            </TableContainer>
        </TableContainer>);
}

export default App;
