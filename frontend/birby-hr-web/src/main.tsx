import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './app/App'
import Matrix from './contexts/matrix/Matrix';
import MatrixContext from './contexts/MatrixContext';

const matrix: Matrix = new Matrix();
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <MatrixContext.Provider value={matrix}>
      <App />
    </MatrixContext.Provider>
  </StrictMode>,
)
