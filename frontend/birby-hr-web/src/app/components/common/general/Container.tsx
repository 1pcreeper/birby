import ContainerProps from "./props/ContainerProps";

function Container({ children }: ContainerProps) {
    return (
        <>
            <div className="max-w-screen-2xl items-center mx-auto p-4">
                {children}
            </div>
        </>
    )
}
export default Container;