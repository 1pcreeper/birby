import { RouterProvider } from 'react-router-dom'
import './App.css'
import { useContext } from 'react'
import MatrixContext from './app/contexts/MatrixContext'

function App() {
  const matrixContext = useContext(MatrixContext);
  return (
    <>
      <RouterProvider router={matrixContext.appRouter.createRouter()}></RouterProvider>
    </>
  )
}
export default App
