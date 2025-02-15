import Matrix from "../../contexts/matrix/Matrix";
import Orchestrator from "../../orchestrators/Orchestrator";
import BackgroundOrchestrator from "../../orchestrators/BackgroundOrchestrator";

class BackgroundProgram {
    private static orchestrator:Orchestrator;
    public static run(matrix: Matrix): void {
        BackgroundProgram.orchestrator = new BackgroundOrchestrator(matrix);
        BackgroundProgram.orchestrator.execute();
    }
}
export default BackgroundProgram;