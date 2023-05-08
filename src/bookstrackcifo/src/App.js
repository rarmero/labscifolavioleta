import { useState } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Table } from "reactstrap"

import {BOOKS} from './mock-books.ts'

function FilterableProductTable({ books }) {
  const [filterText, setFilterText] = useState('');
  const [explainedOnly, setExplainedOnly] = useState(false);

  return (
    <div>
      <SearchBar 
       filterText={filterText} 
       explainedOnly={explainedOnly}
       onFilterTextChange={setFilterText}
       onExplainedOnlyChange={setExplainedOnly}
      />
      <ProductTable books={books} 
      filterText={filterText} 
      explainedOnly={explainedOnly}
      />
    </div>
  );
}

function ProductCategoryRow({ category }) {
  return (
    <tr>
      <th colSpan="2">
        {category}
      </th>
    </tr>
  );
}

function ProductRow({ book }) {
  const title = !book.explained ? book.title :
    <span style={{ color: 'blue' }}>
      {book.title}
    </span>;

  const worked = !book.worked ? book.worked :
  <span style={{ color: 'blue' }}>
  **
  </span>;

const explained = !book.explained ? book.explained :
<span style={{ color: 'blue' }}>
*
</span>;


  return (
    <tr>
      <td>{title}</td>
      <td>{book.author}</td>
      <td>{explained}</td>
      <td>{worked}</td>
    </tr>
  );
}

function ProductTable({ books, filterText, explainedOnly  }) {
  const rows = [];
  let lastCategory = null;

  books.forEach((book) => {
    if (
      book.title.toLowerCase().indexOf(
        filterText.toLowerCase()
      ) === -1
    ) {
      return;
    }
    
    if (explainedOnly && !book.explained) {
      return;
    }

    if (book.category !== lastCategory) {
      rows.push(
        <ProductCategoryRow
          category={book.category}
          key={book.category} />
      );
    }
    rows.push(
      <ProductRow
      book={book}
        key={book.name} 
        />
    );
    lastCategory = book.category;
  });

  return (
    <Table bordered={true}>
    <thead>
      <tr>
        <th>Name</th>
        <th>Title</th>
        <th>Explained</th>
        <th>Worked</th>
      </tr>
    </thead>
    <tbody>{rows}</tbody>
  </Table>
  );
}

function SearchBar({ filterText, explainedOnly,onFilterTextChange,onExplainedOnlyChange })
{
  return (
    <form>
      <input 
        type="text" 
        value={filterText} 
        placeholder="Search..."
        onChange={(e) => onFilterTextChange(e.target.value)} 
        />
      <label>
        <input 
          type="checkbox" 
          checked={explainedOnly}
          onChange={(e) => onExplainedOnlyChange(e.target.checked)} 
          />
        {' '}
        Only show explained books
      </label>
    </form>
  );
}


export default function App() {
  return <FilterableProductTable books={BOOKS} />;
}
