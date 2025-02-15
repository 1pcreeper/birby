import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App'
import MatrixImpl from './contexts/matrix/MatrixImpl';
import MatrixContext from './contexts/MatrixContext';
import Matrix from './contexts/matrix/Matrix';
import BackgroundProgram from './programs/background/BackgroundProgram';

const matrix: Matrix = new MatrixImpl();
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <MatrixContext.Provider value={matrix}>
      <App />
    </MatrixContext.Provider>
  </StrictMode>
);
BackgroundProgram.run(matrix);