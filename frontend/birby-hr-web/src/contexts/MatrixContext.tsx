import { createContext } from "react";
import MatrixImpl from "./matrix/MatrixImpl";
import Matrix from "./matrix/Matrix";

const matrix: MatrixImpl = new MatrixImpl();
const MatrixContext: React.Context<Matrix> = createContext<Matrix>(matrix);
export default MatrixContext;