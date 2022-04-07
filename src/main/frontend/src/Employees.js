import React, {useEffect, useState} from "react";
import axios from "axios";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

const Employees = () => {
    const [employee, setEmployeeData] = useState([]);
    const fetchtEmployees = () => {
        axios.get("http://localhost:8080/employees")
            .then(res => {
                setEmployeeData(res.data);
            });
    };


    useEffect(() => {
        fetchtEmployees()
    }, []);


    return employee.map((employee, index) => {
        return (
            <TableContainer component={Paper}>
                <Table sx={{minWidth: 650}} aria-label="simple table" key={employee.id}>
                    <TableBody key={employee.id}>
                        <TableRow
                            key={employee.id}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <TableCell component="th" scope="row">
                                {employee.name}
                            </TableCell>
                            <TableCell align="right"></TableCell>
                            <TableCell align="right">{employee.id}</TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
            </TableContainer>
        )
    });
};

export default Employees;