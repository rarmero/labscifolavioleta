import PrintGraphicOil from './PrintGraphicOil'
import oilsData from './oil.json'
import { Button } from '@mui/material';
import {ShoppingCartRounded} from '@mui/icons-material/ShoppingCartRounded'
import { Shop } from '@mui/icons-material';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { DataGrid } from '@mui/x-data-grid';

const columns = [
    { field: 'id', headerName: 'ID', width: 70 },
    { field: 'product', headerName: 'product', width: 330 },
    { field: 'SKU', headerName: 'SKU', width: 70 },
    { field: 'price', headerName: 'price', type: 'number', width: 90,},
    { field: 'title', headerName: 'title', width: 300, },
    {
      field: 'xxxxx',
      headerName: 'xxxxx',
      description: 'This column has a value getter and is not sortable.',
      sortable: false,
      width: 160,

      valueGetter: (params) =>
        `${params.row.SKU || ''} ${params.row.volum || ''}`,
    },
  ];

export default function ListOil() {

    return (
        <>
         <h1>Oils </h1>

         <Shop />

         <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>name</TableCell>
            <TableCell align="right">product</TableCell>
            <TableCell align="right">SKU</TableCell>
            <TableCell align="right">Price</TableCell>
            <TableCell align="right">title</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {oilsData.map((row) => (
            <TableRow
              key={row.name}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {row.product}
              </TableCell>
              <TableCell align="right">{row.SKU}</TableCell>
              <TableCell align="right">{row.price}</TableCell>
              <TableCell align="right">{row.title}</TableCell>
              <TableCell align="right">{row.volum}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
               
    <DataGrid

  rows={oilsData}
  columns={columns}
  initialState={{
    pagination: {
      paginationModel: { page: 0, pageSize: 5 },
    },
  }}
  pageSizeOptions={[5, 10]}
  checkboxSelection
/>

        {oilsData.map((entrie) => (
          <li >            
            <strong>Id:</strong> {entrie.id} <br />
            <strong>product:</strong> {entrie.product} <br />
            <strong>SKU:</strong> {entrie.SKU} <br />
            <strong>price:</strong> {entrie.price} <br />
            <strong>title:</strong> {entrie.title} <br />
            <strong>volum:</strong> {entrie.volum} <br />
            <strong>web:</strong> {entrie.web} <br /> 
            <img src={entrie.image} alt={entrie.image} /> <br/> 
            </li>
        ))}
      
     
         <PrintGraphicOil items={oilsData} />


     

</>
);
}  