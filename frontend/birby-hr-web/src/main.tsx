import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App'
import MatrixImpl from './app/contexts/matrix/MatrixImpl';
import MatrixContext from './app/contexts/MatrixContext';
import Matrix from './app/contexts/matrix/Matrix';

const matrix: Matrix = new MatrixImpl();
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <MatrixContext.Provider value={matrix}>
      <App />
    </MatrixContext.Provider>
  </StrictMode>
);