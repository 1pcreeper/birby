import { createContext } from "react";
import Matrix from "./matrix/Matrix";

const matrix: Matrix = new Matrix();
const MatrixContext: React.Context<Matrix> = createContext<Matrix>(matrix);
export default MatrixContext;