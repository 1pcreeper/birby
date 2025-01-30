import { createContext } from "react";
import Matrix from "./matrix/Matrix";
import MatrixType from "./matrix/MatrixType";

const matrix: Matrix = new Matrix();
const MatrixContext: React.Context<MatrixType> = createContext<MatrixType>(matrix);
export default MatrixContext;